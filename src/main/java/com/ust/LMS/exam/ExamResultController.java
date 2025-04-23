package com.ust.LMS.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam-results")
class ExamResultController {
    @Autowired
    private ExamResultService service;

    @GetMapping
    public List<ExamResultDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ExamResultDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ExamResultDTO save(@RequestBody ExamResultDTO dto) {
        return service.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

