package com.ust.LMS.Mapper;

import com.ust.LMS.DTO.BatchDTO;
import com.ust.LMS.Entity.Batch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BatchMapper {

    @Mapping(source = "trainer.trainerId", target = "trainerId")
    BatchDTO toDTO(Batch batch);

    @Mapping(target = "trainer", ignore = true)
    Batch toEntity(BatchDTO dto);
}

