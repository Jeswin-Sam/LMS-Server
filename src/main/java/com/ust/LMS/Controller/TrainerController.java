package com.ust.LMS.Controller;

import com.ust.LMS.DTO.TrainerDTO;
import com.ust.LMS.Service.TrainerService;
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
