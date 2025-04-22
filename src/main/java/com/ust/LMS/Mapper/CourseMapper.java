package com.ust.LMS.Mapper;

import com.ust.LMS.DTO.CourseDTO;
import com.ust.LMS.Entity.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDTO toDTO(Course course);
    Course toEntity(CourseDTO dto);
}
