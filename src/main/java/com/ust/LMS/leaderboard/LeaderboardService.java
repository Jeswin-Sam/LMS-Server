package com.ust.LMS.leaderboard;

import com.ust.LMS.learner.Learner;
import com.ust.LMS.learner.LearnerRepository;
import com.ust.LMS.completedmaterial.CompletedMaterialRepository;
import com.ust.LMS.course_material.CourseMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class LeaderboardService {

    @Autowired
    private LearnerRepository learnerRepository;

    @Autowired
    private CompletedMaterialRepository completedMaterialRepository;

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    public List<LeaderboardDTO> getTopLearners() {
        List<Learner> learners = learnerRepository.findAll();
        long totalMaterials = courseMaterialRepository.count();

        List<LeaderboardDTO> leaderboard = new ArrayList<>();

        for (Learner learner : learners) {
            long completedCount = completedMaterialRepository.countByLearner(learner);
            double percentageCompleted = totalMaterials == 0 ? 0 : (completedCount * 100.0) / totalMaterials;
            leaderboard.add(new LeaderboardDTO(learner.getName(), (int) percentageCompleted));
        }

        leaderboard.sort((a, b) -> b.getPoints() - a.getPoints()); // Highest first

        return leaderboard;
    }
}
