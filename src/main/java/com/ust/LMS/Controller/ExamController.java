package com.ust.LMS.Controller;

import com.ust.LMS.Entity.Exam;
import com.ust.LMS.Service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exams")
public class ExamController {

    @Autowired
    private ExamService examService;

    @GetMapping
    public List<Exam> getAll() {
        return examService.getAllExams();
    }

    @GetMapping("/{id}")
    public Exam getById(@PathVariable Long id) {
        return examService.getExamById(id);
    }

    @PostMapping
    public Exam save(@RequestBody Exam exam) {
        return examService.saveExam(exam);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        examService.deleteExam(id);
    }
}

