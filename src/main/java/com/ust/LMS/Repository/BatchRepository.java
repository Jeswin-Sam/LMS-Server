package com.ust.LMS.Repository;

import com.ust.LMS.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {}

