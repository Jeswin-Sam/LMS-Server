package com.ust.LMS.Entity;

import jakarta.persistence.*;
import org.hibernate.engine.jdbc.batch.spi.Batch;

import java.util.List;

@Entity
public class HRTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hrId;
    private String name;
    private String email;
    private String department;

    @OneToMany(mappedBy = "hrTeam")
    private List<Batch> batches;


    // Getters and Setters
    public Long getHrId() { return hrId; }
    public void setHrId(Long hrId) { this.hrId = hrId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public List<Batch> getBatches() { return batches; }
    public void setBatches(List<Batch> batches) { this.batches = batches; }
}
