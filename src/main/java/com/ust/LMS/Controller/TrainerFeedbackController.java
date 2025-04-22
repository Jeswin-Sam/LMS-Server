package com.ust.LMS.Controller;

import com.ust.LMS.Entity.Feedback.TrainerFeedback;
import com.ust.LMS.Service.TrainerFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainer-feedback")
public class TrainerFeedbackController {

    @Autowired
    private TrainerFeedbackService service;

    @GetMapping
    public List<TrainerFeedback> getAll() {
        return service.getAllFeedback();
    }

    @GetMapping("/{id}")
    public TrainerFeedback getById(@PathVariable Long id) {
        return service.getFeedbackById(id);
    }

    @PostMapping
    public TrainerFeedback save(@RequestBody TrainerFeedback feedback) {
        return service.saveFeedback(feedback);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteFeedback(id);
    }
}
