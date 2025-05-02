package com.ust.LMS.ld_team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class UserOnboardingUtil {

    @Autowired
    private JavaMailSender mailSender;

    public String generateRandomPassword() {
        int length = 8;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#&!";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    public void sendWelcomeEmail(String email, String name, String password, String role) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Welcome to LMS - Login Details");
        message.setText("Dear " + name + ",\n\n"
                + "Your LMS " + role.toLowerCase() + " account has been created.\n"
                + "Here are your login credentials:\n\n"
                + "Email: " + email + "\n"
                + "Password: " + password + "\n\n"
                + "Please login and change your password.\n\n"
                + "Regards,\nLMS Team");
        mailSender.send(message);
    }
}

