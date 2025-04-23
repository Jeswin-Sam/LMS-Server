package com.ust.LMS.feedback;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LDFeedbackMapper {
    LDFeedbackDTO toDTO(LDFeedback feedback);
    LDFeedback toEntity(LDFeedbackDTO dto);
}
