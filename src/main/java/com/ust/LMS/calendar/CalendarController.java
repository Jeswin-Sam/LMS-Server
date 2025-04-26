package com.ust.LMS.calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CalendarController {

    @Autowired
    private CalendarService calendarService;

    @GetMapping("/calendar/events")
    public List<CalendarEventDTO> getCalendarEvents() {
        return calendarService.getAllEvents();
    }
}
