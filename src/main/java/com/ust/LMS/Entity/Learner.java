package com.ust.LMS.Entity;

import com.ust.LMS.Entity.Feedback.ITSupportFeedback;
import com.ust.LMS.Entity.Feedback.LDFeedback;
import com.ust.LMS.Entity.Feedback.TrainerFeedback;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.jdbc.batch.spi.Batch;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Learner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long participantId;
    private String name;
    private String email;
    private String designation;

    @ManyToOne
    @JoinColumn(name = "batch_id")
    private Batch batch;

    @ManyToOne
    @JoinColumn(name = "ld_id")
    private LDTeam ldTeam;

    @OneToMany(mappedBy = "learner")
    private List<TrainerFeedback> trainerFeedbacks;

    @OneToMany(mappedBy = "learner")
    private List<LDFeedback> ldFeedbacks;

    @OneToMany(mappedBy = "learner")
    private List<ITSupportFeedback> itSupportFeedbacks;

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

