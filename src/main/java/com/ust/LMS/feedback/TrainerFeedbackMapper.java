package com.ust.LMS.feedback;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrainerFeedbackMapper {
    TrainerFeedback toEntity(TrainerFeedbackDTO dto);
    TrainerFeedbackDTO toDTO(TrainerFeedback entity);
}
