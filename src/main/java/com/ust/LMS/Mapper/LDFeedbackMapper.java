package com.ust.LMS.Mapper;

import com.ust.LMS.DTO.LDFeedbackDTO;
import com.ust.LMS.Entity.Feedback.LDFeedback;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LDFeedbackMapper {
    LDFeedbackDTO toDTO(LDFeedback feedback);
    LDFeedback toEntity(LDFeedbackDTO dto);
}
