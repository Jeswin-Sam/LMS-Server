package com.ust.LMS.calendar;

import com.ust.LMS.exam.Exam;
import com.ust.LMS.exam.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalendarService {

    @Autowired
    private ExamRepository examRepository;

    public List<CalendarEventDTO> getAllEvents() {
        List<Exam> exams = examRepository.findAll();

        List<CalendarEventDTO> events = new ArrayList<>();
        for (Exam exam : exams) {
            events.add(new CalendarEventDTO(
                    exam.getExamDate().toString(), // format date properly if needed
                    "Exam: " + exam.getExamName()
            ));
        }

        return events;
    }
}
