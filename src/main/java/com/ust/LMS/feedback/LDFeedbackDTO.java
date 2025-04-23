package com.ust.LMS.feedback;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LDFeedbackDTO {
    private Long id;
    private String message;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm a, dd-MM-yyyy")
    private Date submittedDate;

    private Long learnerId;
}
