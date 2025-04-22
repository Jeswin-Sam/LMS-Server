package com.ust.LMS.Service;

import com.ust.LMS.DTO.ExamDTO;
import com.ust.LMS.Entity.Exam;
import com.ust.LMS.Mapper.ExamMapper;
import com.ust.LMS.Repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamService {
    @Autowired private ExamRepository repo;
    @Autowired private ExamMapper mapper;

    public List<ExamDTO> getAll() {
        return repo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public ExamDTO getById(Long id) {
        return repo.findById(id).map(mapper::toDTO).orElse(null);
    }

    public ExamDTO save(ExamDTO dto) {
        Exam entity = mapper.toEntity(dto);
        return mapper.toDTO(repo.save(entity));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

