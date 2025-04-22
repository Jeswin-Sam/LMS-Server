package com.ust.LMS.Mapper;

import com.ust.LMS.DTO.LearnerDTO;
import com.ust.LMS.Entity.Learner;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-22T16:58:23+0530",
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

        learnerDTO.setName( learner.getName() );
        learnerDTO.setEmail( learner.getEmail() );
        learnerDTO.setDesignation( learner.getDesignation() );

        return learnerDTO;
    }
}
