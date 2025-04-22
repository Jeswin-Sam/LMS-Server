package com.ust.LMS.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "batch")
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long batchId;

    private String batchName;
    private Date startDate;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

}

