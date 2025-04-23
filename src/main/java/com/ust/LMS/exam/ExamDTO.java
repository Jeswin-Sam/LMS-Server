package com.ust.LMS.exam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamDTO {
    private Long examId;
    private String examName;
    private Date examDate;
}
