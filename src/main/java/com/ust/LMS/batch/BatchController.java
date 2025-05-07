package com.ust.LMS.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/batch")
@RequiredArgsConstructor
public class BatchController {

    private final BatchService batchService;

    @PostMapping
    public ResponseEntity<BatchDTO> saveBatch(@RequestBody BatchDTO dto) {
        return ResponseEntity.ok(batchService.saveBatch(dto));
    }

    @GetMapping
    public ResponseEntity<List<BatchDTO>> getAllBatches() {
        return ResponseEntity.ok(batchService.getAllBatches());
    }

    @GetMapping("/{batchId}")
    public ResponseEntity<BatchDTO> getBatchById(@PathVariable Long batchId) {
        return ResponseEntity.ok(batchService.getBatchById(batchId));
    }

    @PutMapping("/{batchId}")
    public ResponseEntity<BatchDTO> updateBatch(@PathVariable Long batchId, @RequestBody BatchDTO dto) {
        return ResponseEntity.ok(batchService.updateBatch(batchId, dto));
    }

    @DeleteMapping("/{batchId}")
    public ResponseEntity<Void> deleteBatch(@PathVariable Long batchId) {
        batchService.deleteBatch(batchId);
        return ResponseEntity.noContent().build();
    }
}
