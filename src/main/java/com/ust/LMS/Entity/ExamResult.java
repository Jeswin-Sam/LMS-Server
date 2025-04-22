package com.ust.LMS.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exam_result")
public class ExamResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resultId;

    private Double score;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Learner learner;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;
}
