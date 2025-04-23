package com.ust.LMS.learner;

import com.ust.LMS.batch.Batch;
import com.ust.LMS.course.Course;
import com.ust.LMS.batch.BatchRepository;
import com.ust.LMS.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Batch batch = batchRepository.findById(dto.getBatchId()).orElse(null);
        List<Course> courses = dto.getCourseIds() != null ?
                courseRepository.findAllById(dto.getCourseIds()) : null;

        Learner learner = learnerMapper.toEntity(dto);
        learner.setBatch(batch);
        learner.setCourses(courses);

        return learnerMapper.toDTO(learnerRepository.save(learner));
    }

    public void deleteLearner(Long id) {
        learnerRepository.deleteById(id);
    }
}