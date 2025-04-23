package com.ust.LMS.it_support_team;

import com.ust.LMS.feedback.ITSupportFeedback;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "it_support_team")
public class ITSupportTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supportId;

    private String name;
    private String email;
    private String expertiseArea;

    @OneToMany(mappedBy = "supportTeam")
    private List<ITSupportFeedback> feedbacks;

}
