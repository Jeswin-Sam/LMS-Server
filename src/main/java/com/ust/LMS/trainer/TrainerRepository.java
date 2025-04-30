package com.ust.LMS.trainer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    List<Trainer> findByAvailabilityTrue();
}
