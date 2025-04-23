package com.ust.LMS.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/it-support-feedback")
class ITSupportFeedbackController {
    @Autowired
    private ITSupportFeedbackService service;

    @GetMapping
    public List<ITSupportFeedbackDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ITSupportFeedbackDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ITSupportFeedbackDTO save(@RequestBody ITSupportFeedbackDTO dto) {
        return service.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

