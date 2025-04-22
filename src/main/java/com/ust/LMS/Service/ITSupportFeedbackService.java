package com.ust.LMS.Service;

import com.ust.LMS.Entity.Feedback.ITSupportFeedback;
import com.ust.LMS.Repository.ITSupportFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ITSupportFeedbackService {

    @Autowired
    private ITSupportFeedbackRepository itSupportFeedbackRepository;

    public List<ITSupportFeedback> getAllFeedback() {
        return itSupportFeedbackRepository.findAll();
    }

    public ITSupportFeedback getFeedbackById(Long id) {
        return itSupportFeedbackRepository.findById(id).orElse(null);
    }

    public ITSupportFeedback saveFeedback(ITSupportFeedback feedback) {
        return itSupportFeedbackRepository.save(feedback);
    }

    public void deleteFeedback(Long id) {
        itSupportFeedbackRepository.deleteById(id);
    }
}
