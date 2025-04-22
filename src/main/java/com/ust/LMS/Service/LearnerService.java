package com.ust.LMS.Service;

import com.ust.LMS.Entity.Learner;
import com.ust.LMS.Repository.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearnerService {

    @Autowired
    private LearnerRepository learnerRepository;

    public List<Learner> getAllLearners() {
        return learnerRepository.findAll();
    }

    public Learner getLearnerById(Long id) {
        return learnerRepository.findById(id).orElse(null);
    }

    public Learner saveLearner(Learner learner) {
        return learnerRepository.save(learner);
    }

    public void deleteLearner(Long id) {
        learnerRepository.deleteById(id);
    }
}

