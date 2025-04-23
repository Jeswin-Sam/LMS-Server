package com.ust.LMS.course;

import com.ust.LMS.course_material.CourseMaterial;
import com.ust.LMS.learner.Learner;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String title;
    private String description;
    private String topic;

    private String playlistUrl; // New field for YouTube playlist

    @ManyToMany(mappedBy = "courses")
    private List<Learner> learners;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<CourseMaterial> materials = new ArrayList<>(); // New field
}
