package com.ust.LMS.Controller;

import com.ust.LMS.DTO.ExamDTO;
import com.ust.LMS.Service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exams")
class ExamController {
    @Autowired
    private ExamService service;

    @GetMapping
    public List<ExamDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ExamDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ExamDTO save(@RequestBody ExamDTO dto) {
        return service.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

