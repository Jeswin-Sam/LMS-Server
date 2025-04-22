package com.ust.LMS.Controller;

import com.ust.LMS.Entity.ExamResult;
import com.ust.LMS.Service.ExamResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam-results")
public class ExamResultController {

    @Autowired
    private ExamResultService resultService;

    @GetMapping
    public List<ExamResult> getAll() {
        return resultService.getAllResults();
    }

    @GetMapping("/{id}")
    public ExamResult getById(@PathVariable Long id) {
        return resultService.getResultById(id);
    }

    @PostMapping
    public ExamResult save(@RequestBody ExamResult result) {
        return resultService.saveResult(result);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        resultService.deleteResult(id);
    }
}

