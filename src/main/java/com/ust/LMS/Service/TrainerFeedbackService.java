package com.ust.LMS.Service;

import com.ust.LMS.DTO.TrainerFeedbackDTO;
import com.ust.LMS.Entity.TrainerFeedback;
import com.ust.LMS.Mapper.TrainerFeedbackMapper;
import com.ust.LMS.Repository.TrainerFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerFeedbackService {
    @Autowired private TrainerFeedbackRepository repo;
    @Autowired
    private TrainerFeedbackMapper mapper;

    public List<TrainerFeedbackDTO> getAll() {
        return repo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public TrainerFeedbackDTO getById(Long id) {
        return repo.findById(id).map(mapper::toDTO).orElse(null);
    }

    public TrainerFeedbackDTO save(TrainerFeedbackDTO dto) {
        TrainerFeedback entity = mapper.toEntity(dto);
        return mapper.toDTO(repo.save(entity));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
