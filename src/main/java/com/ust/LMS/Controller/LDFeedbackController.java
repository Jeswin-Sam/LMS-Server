package com.ust.LMS.Controller;

import com.ust.LMS.Entity.Feedback.LDFeedback;
import com.ust.LMS.Service.LDFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ld-feedback")
public class LDFeedbackController {

    @Autowired
    private LDFeedbackService service;

    @GetMapping
    public List<LDFeedback> getAll() {
        return service.getAllFeedback();
    }

    @GetMapping("/{id}")
    public LDFeedback getById(@PathVariable Long id) {
        return service.getFeedbackById(id);
    }

    @PostMapping
    public LDFeedback save(@RequestBody LDFeedback feedback) {
        return service.saveFeedback(feedback);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteFeedback(id);
    }
}
