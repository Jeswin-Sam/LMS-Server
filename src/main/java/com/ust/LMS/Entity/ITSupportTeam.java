package com.ust.LMS.Entity;

import com.ust.LMS.Entity.Feedback.ITSupportFeedback;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class ITSupportTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supportId;
    private String name;
    private String email;
    private String expertiseArea;

    @OneToMany(mappedBy = "supportTeam")
    private List<ITSupportFeedback> feedbacks;

    // Getters and Setters
    public Long getSupportId() { return supportId; }
    public void setSupportId(Long supportId) { this.supportId = supportId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getExpertiseArea() { return expertiseArea; }
    public void setExpertiseArea(String expertiseArea) { this.expertiseArea = expertiseArea; }
    public List<ITSupportFeedback> getFeedbacks() { return feedbacks; }
    public void setFeedbacks(List<ITSupportFeedback> feedbacks) { this.feedbacks = feedbacks; }
}
