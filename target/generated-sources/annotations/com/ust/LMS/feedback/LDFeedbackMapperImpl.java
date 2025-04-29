package com.ust.LMS.feedback;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-29T09:49:12+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Microsoft)"
)
@Component
public class LDFeedbackMapperImpl implements LDFeedbackMapper {

    @Override
    public LDFeedbackDTO toDTO(LDFeedback feedback) {
        if ( feedback == null ) {
            return null;
        }

        LDFeedbackDTO lDFeedbackDTO = new LDFeedbackDTO();

        lDFeedbackDTO.setMessage( feedback.getMessage() );
        lDFeedbackDTO.setSubmittedDate( feedback.getSubmittedDate() );

        return lDFeedbackDTO;
    }

    @Override
    public LDFeedback toEntity(LDFeedbackDTO dto) {
        if ( dto == null ) {
            return null;
        }

        LDFeedback lDFeedback = new LDFeedback();

        lDFeedback.setMessage( dto.getMessage() );
        lDFeedback.setSubmittedDate( dto.getSubmittedDate() );

        return lDFeedback;
    }
}
