package com.ust.LMS.it_support_team;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
}
