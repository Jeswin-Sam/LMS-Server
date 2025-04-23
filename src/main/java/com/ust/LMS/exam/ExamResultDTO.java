package com.ust.LMS.exam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamResultDTO {
    private Long resultId;
    private Double score;
    private Long learnerId;
    private Long examId;
}
