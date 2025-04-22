package com.ust.LMS.Controller;

import com.ust.LMS.Entity.Learner;
import com.ust.LMS.Service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/learners")
public class LearnerController {

    @Autowired
    private LearnerService learnerService;

    @GetMapping
    public List<Learner> getAll() {
        return learnerService.getAllLearners();
    }

    @GetMapping("/{id}")
    public Learner getById(@PathVariable Long id) {
        return learnerService.getLearnerById(id);
    }

    @PostMapping
    public Learner save(@RequestBody Learner learner) {
        return learnerService.saveLearner(learner);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        learnerService.deleteLearner(id);
    }
}
