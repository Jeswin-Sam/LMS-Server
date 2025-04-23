package com.ust.LMS.Mapper;

import com.ust.LMS.DTO.TrainerFeedbackDTO;
import com.ust.LMS.Entity.TrainerFeedback;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrainerFeedbackMapper {
    TrainerFeedback toEntity(TrainerFeedbackDTO dto);
    TrainerFeedbackDTO toDTO(TrainerFeedback entity);
}
