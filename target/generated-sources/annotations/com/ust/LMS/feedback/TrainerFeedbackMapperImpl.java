package com.ust.LMS.feedback;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-23T12:07:53+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Microsoft)"
)
@Component
public class TrainerFeedbackMapperImpl implements TrainerFeedbackMapper {

    @Override
    public TrainerFeedback toEntity(TrainerFeedbackDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TrainerFeedback trainerFeedback = new TrainerFeedback();

        trainerFeedback.setMessage( dto.getMessage() );
        trainerFeedback.setSubmittedDate( dto.getSubmittedDate() );

        return trainerFeedback;
    }

    @Override
    public TrainerFeedbackDTO toDTO(TrainerFeedback entity) {
        if ( entity == null ) {
            return null;
        }

        TrainerFeedbackDTO trainerFeedbackDTO = new TrainerFeedbackDTO();

        trainerFeedbackDTO.setMessage( entity.getMessage() );
        trainerFeedbackDTO.setSubmittedDate( entity.getSubmittedDate() );

        return trainerFeedbackDTO;
    }
}
