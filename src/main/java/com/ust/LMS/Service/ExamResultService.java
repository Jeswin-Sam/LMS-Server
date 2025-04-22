package com.ust.LMS.Service;

import com.ust.LMS.DTO.ExamResultDTO;
import com.ust.LMS.Entity.ExamResult;
import com.ust.LMS.Mapper.ExamResultMapper;
import com.ust.LMS.Repository.ExamResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamResultService {
    @Autowired private ExamResultRepository repo;
    @Autowired private ExamResultMapper mapper;

    public List<ExamResultDTO> getAll() {
        return repo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public ExamResultDTO getById(Long id) {
        return repo.findById(id).map(mapper::toDTO).orElse(null);
    }

    public ExamResultDTO save(ExamResultDTO dto) {
        ExamResult entity = mapper.toEntity(dto);
        return mapper.toDTO(repo.save(entity));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
