package com.ust.LMS.Service;

import com.ust.LMS.DTO.BatchDTO;
import com.ust.LMS.Entity.Batch;
import com.ust.LMS.Entity.Trainer;
import com.ust.LMS.Mapper.BatchMapper;
import com.ust.LMS.Repository.BatchRepository;
import com.ust.LMS.Repository.CourseRepository;
import com.ust.LMS.Repository.LearnerRepository;
import com.ust.LMS.Repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BatchService {

    @Autowired
    private BatchRepository batchRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private LearnerRepository learnerRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private BatchMapper batchMapper;

    public List<BatchDTO> getAllBatches() {
        return batchRepository.findAll().stream().map(batchMapper::toDTO).collect(Collectors.toList());
    }

    public BatchDTO getBatchById(Long id) {
        return batchRepository.findById(id).map(batchMapper::toDTO).orElse(null);
    }

    public BatchDTO saveBatch(BatchDTO dto) {
        Batch batch = batchMapper.toEntity(dto);

        if (dto.getTrainerId() != null) {
            Trainer trainer = trainerRepository.findById(dto.getTrainerId()).orElse(null);
            if (trainer != null) {
                batch.setTrainer(trainer);
                trainer.setIsAvailable(false);
                trainerRepository.save(trainer);
            }
        }

        return batchMapper.toDTO(batchRepository.save(batch));
    }

    public void deleteBatch(Long id) {
        Optional<Batch> optionalBatch = batchRepository.findById(id);
        if (optionalBatch.isPresent()) {
            Batch batch = optionalBatch.get();
            Trainer trainer = batch.getTrainer();
            if (trainer != null) {
                trainer.setIsAvailable(true);
                trainerRepository.save(trainer);
            }
            batchRepository.deleteById(id);
        }
    }
}

