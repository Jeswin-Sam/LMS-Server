package com.ust.LMS.Entity.Feedback;

import com.ust.LMS.Entity.ITSupportTeam;
import com.ust.LMS.Entity.Learner;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ITSupportFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;
    private String message;
    private Date submittedDate;

    @ManyToOne
    @JoinColumn(name = "learner_id")
    private Learner learner;

    @ManyToOne
    @JoinColumn(name = "support_id")
    private ITSupportTeam supportTeam;
}