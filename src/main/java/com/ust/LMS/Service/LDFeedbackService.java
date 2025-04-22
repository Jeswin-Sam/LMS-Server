package com.ust.LMS.Service;

import com.ust.LMS.Entity.Feedback.LDFeedback;
import com.ust.LMS.Repository.LDFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LDFeedbackService {

    @Autowired
    private LDFeedbackRepository ldFeedbackRepository;

    public List<LDFeedback> getAllFeedback() {
        return ldFeedbackRepository.findAll();
    }

    public LDFeedback getFeedbackById(Long id) {
        return ldFeedbackRepository.findById(id).orElse(null);
    }

    public LDFeedback saveFeedback(LDFeedback feedback) {
        return ldFeedbackRepository.save(feedback);
    }

    public void deleteFeedback(Long id) {
        ldFeedbackRepository.deleteById(id);
    }
}
