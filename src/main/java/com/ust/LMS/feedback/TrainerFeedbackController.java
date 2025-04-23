package com.ust.LMS.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainer-feedback")
class TrainerFeedbackController {
    @Autowired
    private TrainerFeedbackService service;

    @GetMapping
    public List<TrainerFeedbackDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TrainerFeedbackDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public TrainerFeedbackDTO save(@RequestBody TrainerFeedbackDTO dto) {
        return service.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
