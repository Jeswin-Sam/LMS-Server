package com.ust.LMS.Mapper;

import com.ust.LMS.DTO.ExamDTO;
import com.ust.LMS.Entity.Exam;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-23T09:53:21+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Microsoft)"
)
@Component
public class ExamMapperImpl implements ExamMapper {

    @Override
    public ExamDTO toDTO(Exam exam) {
        if ( exam == null ) {
            return null;
        }

        ExamDTO examDTO = new ExamDTO();

        examDTO.setExamId( exam.getExamId() );
        examDTO.setExamName( exam.getExamName() );
        examDTO.setExamDate( exam.getExamDate() );

        return examDTO;
    }

    @Override
    public Exam toEntity(ExamDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Exam exam = new Exam();

        exam.setExamId( dto.getExamId() );
        exam.setExamName( dto.getExamName() );
        exam.setExamDate( dto.getExamDate() );

        return exam;
    }
}
