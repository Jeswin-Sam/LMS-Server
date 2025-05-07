package com.ust.LMS.batch;

import com.ust.LMS.course.Course;
import com.ust.LMS.course.CourseRepository;
import com.ust.LMS.learner.Learner;
import com.ust.LMS.learner.LearnerRepository;
import com.ust.LMS.trainer.Trainer;
import com.ust.LMS.trainer.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BatchService {

    private final BatchRepository batchRepository;
    private final BatchMapper batchMapper;
    private final TrainerRepository trainerRepository;
    private final CourseRepository courseRepository;
    private final LearnerRepository learnerRepository;

    public BatchDTO saveBatch(BatchDTO dto) {
        Batch batch = batchMapper.toEntity(dto);

        if (dto.getTrainerId() != null) {
            Optional<Trainer> trainer = trainerRepository.findById(dto.getTrainerId());
            trainer.ifPresent(batch::setTrainer);
        }

        if (dto.getCourseIds() != null) {
            List<Course> courses = courseRepository.findAllById(dto.getCourseIds());
            batch.setCourses(courses);
        }

        if (dto.getLearnerIds() != null) {
            List<Learner> learners = learnerRepository.findAllById(dto.getLearnerIds());
            learners.forEach(l -> l.setBatch(batch));
            batch.setLearners(learners);
        }

        return batchMapper.toDTO(batchRepository.save(batch));
    }

    public List<BatchDTO> getAllBatches() {
        return batchRepository.findAll().stream().map(batchMapper::toDTO).toList();
    }

    public void deleteBatch(Long batchId) {
        batchRepository.deleteById(batchId);
    }

    public BatchDTO getBatchById(Long batchId) {
        return batchMapper.toDTO(batchRepository.findById(batchId).orElseThrow());
    }

    public BatchDTO updateBatch(Long batchId, BatchDTO dto) {
        Batch batch = batchRepository.findById(batchId).orElseThrow();
        batch.setBatchName(dto.getBatchName());

        if (dto.getTrainerId() != null) {
            Trainer trainer = trainerRepository.findById(dto.getTrainerId()).orElseThrow();
            batch.setTrainer(trainer);
        }

        if (dto.getCourseIds() != null) {
            List<Course> courses = courseRepository.findAllById(dto.getCourseIds());
            batch.setCourses(courses);
        }

        if (dto.getLearnerIds() != null) {
            List<Learner> learners = learnerRepository.findAllById(dto.getLearnerIds());
            learners.forEach(l -> l.setBatch(batch));
            batch.setLearners(learners);
        }

        return batchMapper.toDTO(batchRepository.save(batch));
    }
}
