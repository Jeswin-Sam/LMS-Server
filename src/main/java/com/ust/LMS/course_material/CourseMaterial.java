package com.ust.LMS.course_material;

import com.ust.LMS.course.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course_material")
public class CourseMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String youtubeVideoId;
    private int sequenceNumber;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
