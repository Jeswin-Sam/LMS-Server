package com.ust.LMS.completedmaterial;

import com.ust.LMS.learner.Learner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompletedMaterialRepository extends JpaRepository<CompletedMaterial, Long> {
    long countByLearner(Learner learner);
}
