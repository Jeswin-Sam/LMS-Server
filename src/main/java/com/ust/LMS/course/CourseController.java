package com.ust.LMS.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
class CourseController {
    @Autowired
    private CourseService service;

    @GetMapping
    public List<CourseDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CourseDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public CourseDTO save(@RequestBody CourseDTO dto) {
        return service.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteCourse(id);
    }
}
