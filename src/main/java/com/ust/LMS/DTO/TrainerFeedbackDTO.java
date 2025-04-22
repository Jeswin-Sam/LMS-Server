package com.ust.LMS.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainerFeedbackDTO {
    private Long feedbackId;
    private String message;
    private Date submittedDate;
    private Long learnerId;
    private Long trainerId;
    private Long courseId;
}
