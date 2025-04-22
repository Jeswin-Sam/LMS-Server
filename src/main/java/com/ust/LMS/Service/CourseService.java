package com.ust.LMS.Service;

import com.ust.LMS.DTO.CourseDTO;
import com.ust.LMS.Entity.Course;
import com.ust.LMS.Mapper.CourseMapper;
import com.ust.LMS.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    @Autowired private CourseRepository repo;
    @Autowired private CourseMapper mapper;

    public List<CourseDTO> getAll() {
        return repo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public CourseDTO getById(Long id) {
        return repo.findById(id).map(mapper::toDTO).orElse(null);
    }

    public CourseDTO save(CourseDTO dto) {
        Course entity = mapper.toEntity(dto);
        return mapper.toDTO(repo.save(entity));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
