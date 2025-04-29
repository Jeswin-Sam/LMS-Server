package com.ust.LMS.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AppUserRepository userRepo;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Map<String, OtpDetails> otpStorage = new HashMap<>();
    private Map<String, Integer> invalidAttempts = new HashMap<>();

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        AppUser user = userRepo.findByEmail(request.getEmail());
        if (user != null && user.getPassword().equals(request.getPassword())) {
            String token = jwtUtil.generateToken(user.getEmail(), user.getRole());
            LoginResponse response = new LoginResponse(token, user.getEmail(), user.getRole());
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody ForgotPasswordRequest request) {
        AppUser user = userRepo.findByEmail(request.getEmail());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        String otp = String.format("%06d", new Random().nextInt(999999));
        LocalDateTime expiryTime = LocalDateTime.now().plusMinutes(5);

        otpStorage.put(request.getEmail(), new OtpDetails(otp, expiryTime));

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(request.getEmail());
        message.setSubject("LMS Password Reset OTP");
        message.setText("Your OTP for password reset is: " + otp + "\nIt will expire in 5 minutes.");
        mailSender.send(message);

        return ResponseEntity.ok("OTP sent to email successfully");
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(@RequestBody VerifyOtpRequest request) {
        OtpDetails otpDetails = otpStorage.get(request.getEmail());

        if (otpDetails == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No OTP found. Please request again.");
        }

        if (otpDetails.getExpiryTime().isBefore(LocalDateTime.now())) {
            otpStorage.remove(request.getEmail());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("OTP expired. Please request a new one.");
        }

        if (!otpDetails.getOtp().equals(request.getOtp())) {
            int attempts = invalidAttempts.getOrDefault(request.getEmail(), 0) + 1;
            invalidAttempts.put(request.getEmail(), attempts);

            if (attempts >= 5) {
                otpStorage.remove(request.getEmail());
                invalidAttempts.remove(request.getEmail());
                return ResponseEntity.status(HttpStatus.LOCKED).body("Too many invalid attempts. OTP reset.");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid OTP.");
        }

        invalidAttempts.remove(request.getEmail());
        return ResponseEntity.ok("OTP verified successfully");
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequest request) {
        AppUser user = userRepo.findByEmail(request.getEmail());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepo.save(user);

        otpStorage.remove(request.getEmail());

        return ResponseEntity.ok("Password reset successfully");
    }

    private static class OtpDetails {
        private String otp;
        private LocalDateTime expiryTime;

        public OtpDetails(String otp, LocalDateTime expiryTime) {
            this.otp = otp;
            this.expiryTime = expiryTime;
        }

        public String getOtp() {
            return otp;
        }

        public LocalDateTime getExpiryTime() {
            return expiryTime;
        }
    }
}
