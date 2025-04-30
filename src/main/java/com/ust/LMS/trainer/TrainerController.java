package com.ust.LMS.trainer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainers")
public class TrainerController {
    @Autowired
    private TrainerService service;

    @GetMapping
    public List<TrainerDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/available")
    public List<TrainerDTO> getAvailableTrainers() {
        return service.getAvailableTrainers();
    }

    @GetMapping("/{id}")
    public TrainerDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public TrainerDTO save(@RequestBody TrainerDTO dto) {
        return service.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
