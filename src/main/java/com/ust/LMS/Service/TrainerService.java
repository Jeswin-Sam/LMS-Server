package com.ust.LMS.Service;

import com.ust.LMS.DTO.TrainerDTO;
import com.ust.LMS.Entity.Trainer;
import com.ust.LMS.Mapper.TrainerMapper;
import com.ust.LMS.Repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerService {
    @Autowired private TrainerRepository repo;
    @Autowired
    private TrainerMapper mapper;

    public List<TrainerDTO> getAll() {
        return repo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public TrainerDTO getById(Long id) {
        return repo.findById(id).map(mapper::toDTO).orElse(null);
    }

    public TrainerDTO save(TrainerDTO dto) {
        Trainer trainer = mapper.toEntity(dto);

        // Set availability based on batch assignment
        if (dto.getBatchId() != null) {
            trainer.setIsAvailable(false);
        } else {
            trainer.setIsAvailable(true);
        }

        // Save and return DTO
        return mapper.toDTO(repo.save(trainer));
    }


    public void delete(Long id) {
        repo.deleteById(id);
    }
}
