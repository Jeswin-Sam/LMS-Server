package com.ust.LMS.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/batches")
public class BatchController {

    @Autowired
    private BatchService batchService;

    @GetMapping
    public List<BatchDTO> getAll() {
        return batchService.getAllBatches();
    }

    @GetMapping("/{id}")
    public BatchDTO getById(@PathVariable Long id) {
        return batchService.getBatchById(id);
    }

    @PostMapping
    public BatchDTO save(@RequestBody BatchDTO dto) {
        return batchService.saveBatch(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        batchService.deleteBatch(id);
    }
}