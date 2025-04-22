package com.ust.LMS.Mapper;

import com.ust.LMS.DTO.ITSupportFeedbackDTO;
import com.ust.LMS.Entity.Feedback.ITSupportFeedback;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ITSupportFeedbackMapper {
    ITSupportFeedbackDTO toDTO(ITSupportFeedback feedback);
    ITSupportFeedback toEntity(ITSupportFeedbackDTO dto);
}
