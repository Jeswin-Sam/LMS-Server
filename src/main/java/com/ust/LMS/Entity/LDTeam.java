package com.ust.LMS.Entity;

import com.ust.LMS.Entity.Feedback.LDFeedback;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "ld_team")
public class LDTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ldId;

    private String name;
    private String email;
    private String role;

    @OneToMany(mappedBy = "ldTeam")
    private List<Learner> learners;

    @OneToMany(mappedBy = "ldTeam")
    private List<Trainer> trainers;

    @OneToMany(mappedBy = "ldTeam")
    private List<LDFeedback> feedbacks;


}
