package com.ust.LMS.trainer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainerDTO {
    private Long trainerId;
    private String name;
    private String email;
    private String specialization;
    private Boolean availability = true;
    private Long batchId;
}