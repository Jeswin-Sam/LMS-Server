package com.ust.LMS.Mapper;

import com.ust.LMS.DTO.BatchDTO;
import com.ust.LMS.Entity.Batch;
import com.ust.LMS.Entity.Trainer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-22T16:58:23+0530",
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
        batchDTO.setBatchId( batch.getBatchId() );
        batchDTO.setBatchName( batch.getBatchName() );
        batchDTO.setStartDate( batch.getStartDate() );
        batchDTO.setEndDate( batch.getEndDate() );

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
}
