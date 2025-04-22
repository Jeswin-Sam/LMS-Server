package com.ust.LMS.Repository;

import com.ust.LMS.Entity.Learner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearnerRepository extends JpaRepository<Learner, Long> {}