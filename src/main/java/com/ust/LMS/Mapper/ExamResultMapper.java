package com.ust.LMS.Mapper;

import com.ust.LMS.DTO.ExamResultDTO;
import com.ust.LMS.Entity.ExamResult;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExamResultMapper {
    ExamResultDTO toDTO(ExamResult result);
    ExamResult toEntity(ExamResultDTO dto);
}
