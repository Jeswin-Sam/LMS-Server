package com.ust.LMS.progress_tracking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findByCourse_CourseIdOrderBySequenceNumberAsc(Long courseId);
}
