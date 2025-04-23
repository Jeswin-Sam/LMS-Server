package com.ust.LMS.feedback;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ITSupportFeedbackMapper {
    ITSupportFeedbackDTO toDTO(ITSupportFeedback feedback);
    ITSupportFeedback toEntity(ITSupportFeedbackDTO dto);
}
