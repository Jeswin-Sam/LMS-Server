package com.ust.LMS.course;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-23T12:07:53+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Microsoft)"
)
@Component
public class CourseMapperImpl implements CourseMapper {

    @Override
    public CourseDTO toDTO(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDTO courseDTO = new CourseDTO();

        courseDTO.setCourseId( course.getCourseId() );
        courseDTO.setTitle( course.getTitle() );
        courseDTO.setDescription( course.getDescription() );
        courseDTO.setTopic( course.getTopic() );
        courseDTO.setPlaylistUrl( course.getPlaylistUrl() );

        return courseDTO;
    }

    @Override
    public Course toEntity(CourseDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Course course = new Course();

        course.setCourseId( dto.getCourseId() );
        course.setTitle( dto.getTitle() );
        course.setDescription( dto.getDescription() );
        course.setTopic( dto.getTopic() );
        course.setPlaylistUrl( dto.getPlaylistUrl() );

        return course;
    }
}
