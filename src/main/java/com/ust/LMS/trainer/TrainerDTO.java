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
    private Boolean isAvailable;
    private Long batchId;
}