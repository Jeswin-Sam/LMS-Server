package com.ust.LMS.learner;

import com.ust.LMS.batch.BatchRepository;
import com.ust.LMS.course.Course;
import com.ust.LMS.course.CourseDTO;
import com.ust.LMS.course.CourseRepository;
import com.ust.LMS.ld_team.UserOnboardingUtil;
import com.ust.LMS.security.AppUser;
import com.ust.LMS.security.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LearnerService {

    @Autowired private LearnerRepository learnerRepository;
    @Autowired private BatchRepository batchRepository;
    @Autowired private CourseRepository courseRepository;
    @Autowired private LearnerMapper learnerMapper;
    @Autowired private AppUserRepository appUserRepository;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private JavaMailSender mailSender;
    @Autowired private UserOnboardingUtil onboardingUtil;

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
        String randomPassword = onboardingUtil.generateRandomPassword();

        // Create AppUser
        AppUser user = new AppUser(
                dto.getEmail(),
                passwordEncoder.encode(randomPassword),
                "LEARNER",
                dto.getName());

        appUserRepository.save(user);

        // Send welcome email
        onboardingUtil.sendWelcomeEmail(dto.getEmail(), dto.getName(), randomPassword, "LEARNER");
        return learnerMapper.toDTO(learnerRepository.save(learner));
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