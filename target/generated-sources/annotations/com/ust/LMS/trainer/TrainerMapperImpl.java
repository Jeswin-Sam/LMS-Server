package com.ust.LMS.trainer;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-23T12:07:53+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Microsoft)"
)
@Component
public class TrainerMapperImpl implements TrainerMapper {

    @Override
    public TrainerDTO toDTO(Trainer trainer) {
        if ( trainer == null ) {
            return null;
        }

        TrainerDTO trainerDTO = new TrainerDTO();

        trainerDTO.setTrainerId( trainer.getTrainerId() );
        trainerDTO.setName( trainer.getName() );
        trainerDTO.setEmail( trainer.getEmail() );
        trainerDTO.setIsAvailable( trainer.getIsAvailable() );

        trainerDTO.setBatchId( (trainer.getBatches() != null && !trainer.getBatches().isEmpty()) ? trainer.getBatches().get(0).getBatchId() : null );

        return trainerDTO;
    }

    @Override
    public Trainer toEntity(TrainerDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Trainer trainer = new Trainer();

        trainer.setTrainerId( dto.getTrainerId() );
        trainer.setName( dto.getName() );
        trainer.setEmail( dto.getEmail() );

        trainer.setIsAvailable( true );

        return trainer;
    }
}
