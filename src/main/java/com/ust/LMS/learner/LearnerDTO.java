package com.ust.LMS.learner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LearnerDTO {
    private Long learnerId;
    private String name;
    private String email;
    private String designation;
    private Long batchId;
    private List<Long> courseIds;
    private List<String> courseNames;
}
