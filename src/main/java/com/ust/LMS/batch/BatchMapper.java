package com.ust.LMS.batch;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface BatchMapper {

    @Mapping(source = "trainer.trainerId", target = "trainerId")
    @Mapping(source = "trainer.name", target = "trainerName")
    @Mapping(target = "courseNames", expression = "java(batch.getCourses() != null ? batch.getCourses().stream().map(c -> c.getTitle()).collect(Collectors.toList()) : null)")
    @Mapping(target = "courseIds", expression = "java(batch.getCourses() != null ? batch.getCourses().stream().map(c -> c.getCourseId()).collect(Collectors.toList()) : null)")
    @Mapping(target = "learnerNames", expression = "java(batch.getLearners() != null ? batch.getLearners().stream().map(l -> l.getName()).collect(Collectors.toList()) : null)")
    @Mapping(target = "learnerIds", expression = "java(batch.getLearners() != null ? batch.getLearners().stream().map(l -> l.getLearnerId()).collect(Collectors.toList()) : null)")
    BatchDTO toDTO(Batch batch);

    @Mappings({
            @Mapping(target = "trainer", ignore = true),
            @Mapping(target = "courses", ignore = true),
            @Mapping(target = "learners", ignore = true)
    })
    Batch toEntity(BatchDTO dto);
}
