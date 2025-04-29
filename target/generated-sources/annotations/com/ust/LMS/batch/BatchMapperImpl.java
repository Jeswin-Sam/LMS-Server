package com.ust.LMS.batch;

import com.ust.LMS.trainer.Trainer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-29T15:06:51+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Microsoft)"
)
@Component
public class BatchMapperImpl implements BatchMapper {

    @Override
    public BatchDTO toDTO(Batch batch) {
        if ( batch == null ) {
            return null;
        }

        BatchDTO batchDTO = new BatchDTO();

        batchDTO.setTrainerId( batchTrainerTrainerId( batch ) );
        batchDTO.setTrainerName( batchTrainerName( batch ) );
        batchDTO.setBatchId( batch.getBatchId() );
        batchDTO.setBatchName( batch.getBatchName() );
        batchDTO.setStartDate( batch.getStartDate() );
        batchDTO.setEndDate( batch.getEndDate() );

        batchDTO.setCourseNames( batch.getCourses() != null ? batch.getCourses().stream().map(c -> c.getTitle()).collect(java.util.stream.Collectors.toList()) : null );
        batchDTO.setCourseIds( batch.getCourses() != null ? batch.getCourses().stream().map(c -> c.getCourseId()).collect(java.util.stream.Collectors.toList()) : null );

        return batchDTO;
    }

    @Override
    public Batch toEntity(BatchDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Batch batch = new Batch();

        batch.setBatchId( dto.getBatchId() );
        batch.setBatchName( dto.getBatchName() );
        batch.setStartDate( dto.getStartDate() );
        batch.setEndDate( dto.getEndDate() );

        return batch;
    }

    private Long batchTrainerTrainerId(Batch batch) {
        if ( batch == null ) {
            return null;
        }
        Trainer trainer = batch.getTrainer();
        if ( trainer == null ) {
            return null;
        }
        Long trainerId = trainer.getTrainerId();
        if ( trainerId == null ) {
            return null;
        }
        return trainerId;
    }

    private String batchTrainerName(Batch batch) {
        if ( batch == null ) {
            return null;
        }
        Trainer trainer = batch.getTrainer();
        if ( trainer == null ) {
            return null;
        }
        String name = trainer.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
