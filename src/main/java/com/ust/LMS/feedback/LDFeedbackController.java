package com.ust.LMS.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ld-feedback")
class LDFeedbackController {
    @Autowired private LDFeedbackService service;

    @GetMapping
    public List<LDFeedbackDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public LDFeedbackDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public LDFeedbackDTO save(@RequestBody LDFeedbackDTO dto) {
        return service.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

