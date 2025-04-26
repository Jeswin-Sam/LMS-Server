package com.ust.LMS.learner;

import com.ust.LMS.course.CourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import java.util.List;

@RestController
@RequestMapping("/learners")
public class LearnerController {

    @Autowired
    private LearnerService learnerService;

    @GetMapping
    public List<LearnerDTO> getAll() {
        return learnerService.getAllLearners();
    }

    @GetMapping("/{id}")
    public LearnerDTO getById(@PathVariable Long id) {
        return learnerService.getLearnerById(id);
    }

    @GetMapping("/learner/courses")
    public List<CourseDTO> getCoursesForLearner(Authentication authentication) {
        String email = authentication.getName(); // assuming email as username
        return learnerService.getCoursesForLearner(email);
    }

    @PostMapping
    public LearnerDTO save(@RequestBody LearnerDTO dto) {
        return learnerService.saveLearner(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        learnerService.deleteLearner(id);
    }
}

