package com.ust.LMS.Service;

import com.ust.LMS.Entity.ExamResult;
import com.ust.LMS.Repository.ExamResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamResultService {

    @Autowired
    private ExamResultRepository examResultRepository;

    public List<ExamResult> getAllResults() {
        return examResultRepository.findAll();
    }

    public ExamResult getResultById(Long id) {
        return examResultRepository.findById(id).orElse(null);
    }

    public ExamResult saveResult(ExamResult result) {
        return examResultRepository.save(result);
    }

    public void deleteResult(Long id) {
        examResultRepository.deleteById(id);
    }
}
