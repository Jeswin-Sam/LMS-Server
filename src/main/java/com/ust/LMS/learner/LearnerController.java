package com.ust.LMS.learner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public LearnerDTO save(@RequestBody LearnerDTO dto) {
        return learnerService.saveLearner(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        learnerService.deleteLearner(id);
    }
}

