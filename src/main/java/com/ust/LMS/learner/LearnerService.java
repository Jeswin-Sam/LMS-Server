package com.ust.LMS.learner;

import com.ust.LMS.batch.BatchRepository;
import com.ust.LMS.course.Course;
import com.ust.LMS.course.CourseDTO;
import com.ust.LMS.course.CourseRepository;
import com.ust.LMS.security.AppUser;
import com.ust.LMS.security.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class LearnerService {

    @Autowired
    private LearnerRepository learnerRepository;
    @Autowired
    private BatchRepository batchRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private LearnerMapper learnerMapper;
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JavaMailSender mailSender;

    public List<LearnerDTO> getAllLearners() {
        return learnerRepository.findAll().stream()
                .map(learnerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public LearnerDTO getLearnerById(Long id) {
        return learnerRepository.findById(id)
                .map(learnerMapper::toDTO)
                .orElse(null);
    }

    public LearnerDTO saveLearner(LearnerDTO dto) {
        Learner learner = learnerMapper.toEntity(dto);
        learnerRepository.save(learner);

        // Generate random password
        String randomPassword = generateRandomPassword();

        // Create AppUser
        AppUser user = new AppUser(
                dto.getEmail(),
                passwordEncoder.encode(randomPassword),
                "LEARNER",
                dto.getName());

        appUserRepository.save(user);

        // Send welcome email
        sendWelcomeEmail(dto.getEmail(), dto.getName(), randomPassword);

        return learnerMapper.toDTO(learnerRepository.save(learner));
    }

    private void sendWelcomeEmail(String email, String name, String password) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Welcome to LMS - Login Details");
        message.setText("Dear " + name + ",\n\n"
                + "Your LMS Learner account has been created.\n"
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


    public List<CourseDTO> getCoursesForLearner(String email) {
        Learner learner = learnerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Learner not found"));

        List<CourseDTO> courseDTOs = new ArrayList<>();

        for (Course course : learner.getBatch().getCourses()) {
            CourseDTO dto = new CourseDTO();
            dto.setTitle(course.getTitle());
            dto.setDescription(course.getDescription());
            courseDTOs.add(dto);
        }

        return courseDTOs;
    }


    public void deleteLearner(Long id) {
        learnerRepository.deleteById(id);
    }
}