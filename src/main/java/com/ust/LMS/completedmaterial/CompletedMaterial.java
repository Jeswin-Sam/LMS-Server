package com.ust.LMS.completedmaterial;

import com.ust.LMS.learner.Learner;
import com.ust.LMS.course_material.CourseMaterial;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "completed_materials")
public class CompletedMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Learner learner;

    @ManyToOne
    private CourseMaterial material;
}
