package com.ust.LMS.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ITSupportFeedbackService {
    @Autowired private ITSupportFeedbackRepository repo;
    @Autowired private ITSupportFeedbackMapper mapper;

    public List<ITSupportFeedbackDTO> getAll() {
        return repo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public ITSupportFeedbackDTO getById(Long id) {
        return repo.findById(id).map(mapper::toDTO).orElse(null);
    }

    public ITSupportFeedbackDTO save(ITSupportFeedbackDTO dto) {
        ITSupportFeedback entity = mapper.toEntity(dto);
        return mapper.toDTO(repo.save(entity));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
