package com.ust.LMS.trainer;

import com.ust.LMS.batch.Batch;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "trainer")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainerId;

    private String name;
    private String email;
    private String specialization;

    @OneToOne
    private Batch batch;

    @Column(nullable = false)
    private Boolean availability = true;

}
