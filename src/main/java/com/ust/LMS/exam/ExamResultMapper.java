package com.ust.LMS.exam;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExamResultMapper {
    ExamResultDTO toDTO(ExamResult result);
    ExamResult toEntity(ExamResultDTO dto);
}
