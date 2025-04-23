package com.ust.LMS.learner;

import com.ust.LMS.course.Course;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface LearnerMapper {

    Learner toEntity(LearnerDTO dto);

    LearnerDTO toDTO(Learner learner);

    default List<Long> mapCourseIds(Learner learner) {
        if (learner.getCourses() == null) return null;
        return learner.getCourses().stream().map(Course::getCourseId).collect(Collectors.toList());
    }
}

