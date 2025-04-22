package com.ust.LMS.Entity;

import jakarta.persistence.*;
import org.hibernate.engine.jdbc.batch.spi.Batch;

import java.util.List;

@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainerId;
    private String name;
    private String email;
    private String specialization;

    @OneToMany(mappedBy = "trainer")
    private List<Batch> batches;

    @ManyToOne
    @JoinColumn(name = "ld_id")
    private LDTeam ldTeam;

    // Getters and Setters
    public Long getTrainerId() { return trainerId; }
    public void setTrainerId(Long trainerId) { this.trainerId = trainerId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public List<Batch> getBatches() { return batches; }
    public void setBatches(List<Batch> batches) { this.batches = batches; }
    public LDTeam getLdTeam() { return ldTeam; }
    public void setLdTeam(LDTeam ldTeam) { this.ldTeam = ldTeam; }
}
