package com.ust.LMS.feedback;

import com.ust.LMS.learner.Learner;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ld_feedback")
public class LDFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;

    private String message;
    private Date submittedDate;

    @ManyToOne
    @JoinColumn(name = "learner_id")
    private Learner learner;

}
