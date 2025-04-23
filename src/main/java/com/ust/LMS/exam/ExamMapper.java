package com.ust.LMS.exam;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExamMapper {
    ExamDTO toDTO(Exam exam);
    Exam toEntity(ExamDTO dto);
}
