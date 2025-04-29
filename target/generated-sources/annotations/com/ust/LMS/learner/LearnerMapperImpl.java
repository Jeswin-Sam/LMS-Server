package com.ust.LMS.learner;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-29T15:06:50+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Microsoft)"
)
@Component
public class LearnerMapperImpl implements LearnerMapper {

    @Override
    public Learner toEntity(LearnerDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Learner learner = new Learner();

        learner.setLearnerId( dto.getLearnerId() );
        learner.setName( dto.getName() );
        learner.setEmail( dto.getEmail() );
        learner.setDesignation( dto.getDesignation() );

        return learner;
    }

    @Override
    public LearnerDTO toDTO(Learner learner) {
        if ( learner == null ) {
            return null;
        }

        LearnerDTO learnerDTO = new LearnerDTO();

        learnerDTO.setLearnerId( learner.getLearnerId() );
        learnerDTO.setName( learner.getName() );
        learnerDTO.setEmail( learner.getEmail() );
        learnerDTO.setDesignation( learner.getDesignation() );

        return learnerDTO;
    }
}
