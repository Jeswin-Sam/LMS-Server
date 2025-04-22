package com.ust.LMS.Service;

import com.ust.LMS.Entity.Feedback.TrainerFeedback;
import com.ust.LMS.Repository.TrainerFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerFeedbackService {

    @Autowired
    private TrainerFeedbackRepository trainerFeedbackRepository;

    public List<TrainerFeedback> getAllFeedback() {
        return trainerFeedbackRepository.findAll();
    }

    public TrainerFeedback getFeedbackById(Long id) {
        return trainerFeedbackRepository.findById(id).orElse(null);
    }

    public TrainerFeedback saveFeedback(TrainerFeedback feedback) {
        return trainerFeedbackRepository.save(feedback);
    }

    public void deleteFeedback(Long id) {
        trainerFeedbackRepository.deleteById(id);
    }
}
