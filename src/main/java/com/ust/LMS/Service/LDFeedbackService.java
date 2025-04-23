package com.ust.LMS.Service;

import com.ust.LMS.DTO.LDFeedbackDTO;
import com.ust.LMS.Entity.LDFeedback;
import com.ust.LMS.Mapper.LDFeedbackMapper;
import com.ust.LMS.Repository.LDFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LDFeedbackService {
    @Autowired private LDFeedbackRepository repo;
    @Autowired private LDFeedbackMapper mapper;

    public List<LDFeedbackDTO> getAll() {
        return repo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public LDFeedbackDTO getById(Long id) {
        return repo.findById(id).map(mapper::toDTO).orElse(null);
    }

    public LDFeedbackDTO save(LDFeedbackDTO dto) {
        LDFeedback entity = mapper.toEntity(dto);
        return mapper.toDTO(repo.save(entity));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
