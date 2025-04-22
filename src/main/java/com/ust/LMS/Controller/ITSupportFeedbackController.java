package com.ust.LMS.Controller;

import com.ust.LMS.Entity.Feedback.ITSupportFeedback;
import com.ust.LMS.Service.ITSupportFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/it-support-feedback")
public class ITSupportFeedbackController {

    @Autowired
    private ITSupportFeedbackService service;

    @GetMapping
    public List<ITSupportFeedback> getAll() {
        return service.getAllFeedback();
    }

    @GetMapping("/{id}")
    public ITSupportFeedback getById(@PathVariable Long id) {
        return service.getFeedbackById(id);
    }

    @PostMapping
    public ITSupportFeedback save(@RequestBody ITSupportFeedback feedback) {
        return service.saveFeedback(feedback);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteFeedback(id);
    }
}

