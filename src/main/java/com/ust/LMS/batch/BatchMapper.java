package com.ust.LMS.batch;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface BatchMapper {

    @Mapping(source = "trainer.trainerId", target = "trainerId")
    @Mapping(source = "trainer.name", target = "trainerName")
    @Mapping(target = "courseNames", expression = "java(batch.getCourses() != null ? batch.getCourses().stream().map(c -> c.getTitle()).collect(java.util.stream.Collectors.toList()) : null)")
    @Mapping(target = "courseIds", expression = "java(batch.getCourses() != null ? batch.getCourses().stream().map(c -> c.getCourseId()).collect(java.util.stream.Collectors.toList()) : null)")
    BatchDTO toDTO(Batch batch);

    @Mappings({
            @Mapping(target = "trainer", ignore = true),
            @Mapping(target = "courses", ignore = true)
    })
    Batch toEntity(BatchDTO dto);
}
