package com.ust.LMS.Mapper;

import com.ust.LMS.DTO.ExamDTO;
import com.ust.LMS.Entity.Exam;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExamMapper {
    ExamDTO toDTO(Exam exam);
    Exam toEntity(ExamDTO dto);
}
