package com.ust.LMS.trainer;

import com.ust.LMS.security.AppUser;
import com.ust.LMS.security.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class TrainerService {
    @Autowired private TrainerRepository repo;
    @Autowired private TrainerMapper mapper;
    @Autowired private AppUserRepository appUserRepository;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private JavaMailSender mailSender;

    public List<TrainerDTO> getAll() {
        return repo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public TrainerDTO getById(Long id) {
        return repo.findById(id).map(mapper::toDTO).orElse(null);
    }

    public TrainerDTO save(TrainerDTO dto) {
        Trainer trainer = mapper.toEntity(dto);
        repo.save(trainer);

        // Generate random password
        String randomPassword = generateRandomPassword();

        // Create AppUser
        AppUser user = new AppUser();
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(randomPassword));
        user.setRole("TRAINER");
        appUserRepository.save(user);

        // Send welcome email
        sendWelcomeEmail(dto.getEmail(), dto.getName(), randomPassword);

        return mapper.toDTO(repo.save(trainer));
    }

    private void sendWelcomeEmail(String email, String name, String password) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Welcome to LMS - Login Details");
        message.setText("Dear " + name + ",\n\n"
                + "Your LMS Trainer account has been created.\n"
                + "Here are your login credentials:\n\n"
                + "Email: " + email + "\n"
                + "Password: " + password + "\n\n"
                + "Please login and change your password.\n\n"
                + "Regards,\nLMS Team");
        mailSender.send(message);
    }

    private String generateRandomPassword() {
        int length = 8;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#&!";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }


    public void delete(Long id) {
        repo.deleteById(id);
    }
}
