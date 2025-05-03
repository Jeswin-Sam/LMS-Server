package com.ust.LMS.progress_tracking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface LearnerVideoProgressRepository extends JpaRepository<LearnerVideoProgress, Long> {

    List<LearnerVideoProgress> findByLearner_LearnerIdAndVideo_Course_CourseId(Long learnerId, Long courseId);

    Optional<LearnerVideoProgress> findByLearner_LearnerIdAndVideo_Id(Long learnerId, Long videoId);

    boolean existsByLearner_LearnerIdAndVideo_Id(Long learnerId, Long videoId);

    long countByLearner_LearnerIdAndVideo_Course_CourseIdAndCompletedTrue(Long learnerId, Long courseId);
}

