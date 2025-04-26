package com.ust.LMS.calendar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalendarEventDTO {
    private String date;  // format: "2025-06-01"
    private String title; // Event title
}
