package com.ust.LMS.Mapper;

import com.ust.LMS.DTO.TrainerFeedbackDTO;
import com.ust.LMS.Entity.Feedback.TrainerFeedback;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrainerFeedbackMapper {
    TrainerFeedbackDTO toDTO(TrainerFeedback feedback);
    TrainerFeedback toEntity(TrainerFeedbackDTO dto);
}
