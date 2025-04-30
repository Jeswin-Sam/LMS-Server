package com.ust.LMS.trainer;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TrainerMapper {

    @Mappings({
            @Mapping(target = "batchId", expression = "java(trainer.getBatch() != null ? trainer.getBatch().getBatchId() : null)"),
            @Mapping(target = "availability", source = "availability")
    })
    TrainerDTO toDTO(Trainer trainer);

    @Mappings({
            @Mapping(target = "batch", ignore = true),
            @Mapping(target = "specialization", source = "specialization"),
            @Mapping(target = "availability", source = "availability")
    })
    Trainer toEntity(TrainerDTO dto);
}
