package com.ust.LMS.Entity;

import com.ust.LMS.Entity.Feedback.LDFeedback;
import jakarta.persistence.*;

import java.util.List;

@Entity
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



    // Getters and Setters
    public Long getLdId() { return ldId; }
    public void setLdId(Long ldId) { this.ldId = ldId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public List<Learner> getLearners() { return learners; }
    public void setLearners(List<Learner> learners) { this.learners = learners; }
    public List<Trainer> getTrainers() { return trainers; }
    public void setTrainers(List<Trainer> trainers) { this.trainers = trainers; }
    public List<LDFeedback> getFeedbacks() { return feedbacks; }
    public void setFeedbacks(List<LDFeedback> feedbacks) { this.feedbacks = feedbacks; }
}
