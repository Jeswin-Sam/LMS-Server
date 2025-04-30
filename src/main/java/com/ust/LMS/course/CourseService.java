package com.ust.LMS.course;

import com.ust.LMS.course_material.CourseMaterial;
import com.ust.LMS.learner.Learner;
import com.ust.LMS.learner.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    @Autowired private CourseRepository repo;
    @Autowired private LearnerRepository learnerRepository;
    @Autowired private CourseMapper mapper;
    @Autowired private YouTubePlaylistService playlistService; // new

    public List<CourseDTO> getAll() {
        return repo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public CourseDTO getById(Long id) {
        return repo.findById(id).map(mapper::toDTO).orElse(null);
    }

    public CourseDTO save(CourseDTO dto) {
        Course entity = mapper.toEntity(dto);
        if (entity.getPlaylistUrl() != null && !entity.getPlaylistUrl().isEmpty()) {
            List<CourseMaterial> materials = playlistService.extractMaterialsFromPlaylist(entity.getPlaylistUrl(), entity);
            entity.setMaterials(materials);
        }
        return mapper.toDTO(repo.save(entity));
    }

    public void deleteCourse(Long courseId) {
        Course course = repo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));

        // Step 1: Remove this course from all learners
        List<Learner> learners = learnerRepository.findAll();
        for (Learner learner : learners) {
            if (learner.getCourses().contains(course)) {
                learner.getCourses().remove(course);
                learnerRepository.save(learner); // update learner record
            }
        }

        // Step 2: Now delete the course safely
        repo.delete(course);
    }}

