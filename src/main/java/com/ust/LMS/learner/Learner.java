package com.ust.LMS.learner;

import com.ust.LMS.batch.Batch;
import com.ust.LMS.course.Course;
import com.ust.LMS.exam.ExamResult;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "learner")
public class Learner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long learnerId;

    private String name;
    private String email;
    private String designation;

    @ManyToOne
    @JoinColumn(name = "batch_id")
    private Batch batch;

    @OneToMany(mappedBy = "learner")
    private List<ExamResult> examResults;

    @ManyToMany
    @JoinTable(
            name = "learner_courses",
            joinColumns = @JoinColumn(name = "learner_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;
}

