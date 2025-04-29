package com.ust.LMS.feedback;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-29T09:49:11+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Microsoft)"
)
@Component
public class ITSupportFeedbackMapperImpl implements ITSupportFeedbackMapper {

    @Override
    public ITSupportFeedbackDTO toDTO(ITSupportFeedback feedback) {
        if ( feedback == null ) {
            return null;
        }

        ITSupportFeedbackDTO iTSupportFeedbackDTO = new ITSupportFeedbackDTO();

        iTSupportFeedbackDTO.setMessage( feedback.getMessage() );
        iTSupportFeedbackDTO.setSubmittedDate( feedback.getSubmittedDate() );

        return iTSupportFeedbackDTO;
    }

    @Override
    public ITSupportFeedback toEntity(ITSupportFeedbackDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ITSupportFeedback iTSupportFeedback = new ITSupportFeedback();

        iTSupportFeedback.setMessage( dto.getMessage() );
        iTSupportFeedback.setSubmittedDate( dto.getSubmittedDate() );

        return iTSupportFeedback;
    }
}
