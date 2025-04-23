package com.ust.LMS.Mapper;

import com.ust.LMS.DTO.ExamResultDTO;
import com.ust.LMS.Entity.ExamResult;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-23T09:53:21+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Microsoft)"
)
@Component
public class ExamResultMapperImpl implements ExamResultMapper {

    @Override
    public ExamResultDTO toDTO(ExamResult result) {
        if ( result == null ) {
            return null;
        }

        ExamResultDTO examResultDTO = new ExamResultDTO();

        examResultDTO.setResultId( result.getResultId() );
        examResultDTO.setScore( result.getScore() );

        return examResultDTO;
    }

    @Override
    public ExamResult toEntity(ExamResultDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ExamResult examResult = new ExamResult();

        examResult.setResultId( dto.getResultId() );
        examResult.setScore( dto.getScore() );

        return examResult;
    }
}
