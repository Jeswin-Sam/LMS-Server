package com.ust.LMS.Mapper;

import com.ust.LMS.DTO.TrainerDTO;
import com.ust.LMS.Entity.Trainer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TrainerMapper {

    @Mapping(target = "batchId", expression = "java((trainer.getBatches() != null && !trainer.getBatches().isEmpty()) ? trainer.getBatches().get(0).getBatchId() : null)")
    TrainerDTO toDTO(Trainer trainer);

    @Mappings({
            @Mapping(target = "batches", ignore = true),
            @Mapping(target = "isAvailable", constant = "true"),
            @Mapping(target = "specialization", ignore = true)
    })
    Trainer toEntity(TrainerDTO dto);
}
