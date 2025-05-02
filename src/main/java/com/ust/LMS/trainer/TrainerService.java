package com.ust.LMS.trainer;

import com.ust.LMS.ld_team.UserOnboardingUtil;
import com.ust.LMS.security.AppUser;
import com.ust.LMS.security.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerService {
    @Autowired private TrainerRepository repo;
    @Autowired private TrainerMapper trainerMapper;
    @Autowired private AppUserRepository appUserRepository;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private JavaMailSender mailSender;
    @Autowired private UserOnboardingUtil onboardingUtil;

    public List<TrainerDTO> getAll() {
        return repo.findAll().stream().map(trainerMapper::toDTO).collect(Collectors.toList());
    }

    public List<TrainerDTO> getAvailableTrainers() {
        return repo.findByAvailabilityTrue()
                .stream()
                .map(trainerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TrainerDTO getById(Long id) {
        return repo.findById(id).map(trainerMapper::toDTO).orElse(null);
    }

    public TrainerDTO save(TrainerDTO dto) {
        Trainer trainer = trainerMapper.toEntity(dto);
        repo.save(trainer);

        // Generate random password
        String randomPassword = onboardingUtil.generateRandomPassword();

        // Create AppUser
        AppUser user = new AppUser(
                dto.getEmail(),
                passwordEncoder.encode(randomPassword),
                "TRAINER",
                dto.getName());

        appUserRepository.save(user);

        // Send welcome email
        onboardingUtil.sendWelcomeEmail(
                dto.getEmail(),
                dto.getName(),
                randomPassword,
                "TRAINER");

        return trainerMapper.toDTO(repo.save(trainer));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
