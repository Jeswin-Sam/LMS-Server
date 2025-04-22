package com.ust.LMS.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "hr_team")
public class HRTeam {
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hrId;

    private String name;
    private String email;
    private String department;

    @OneToMany(mappedBy = "hrTeam")
    private List<Batch> batches;


}
