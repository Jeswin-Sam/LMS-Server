package com.ust.LMS.progress_tracking;

import com.ust.LMS.learner.Learner;
import com.ust.LMS.learner.LearnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LearnerProgressService {

    private final LearnerVideoProgressRepository progressRepository;
    private final VideoRepository videoRepository;
    private final LearnerRepository learnerRepository;

    public void markVideoAsCompleted(Long learnerId, Long videoId) {
        Learner learner = learnerRepository.findById(learnerId)
                .orElseThrow(() -> new RuntimeException("Learner not found"));
        Video video = videoRepository.findById(videoId)
                .orElseThrow(() -> new RuntimeException("Video not found"));

        LearnerVideoProgress progress = progressRepository.findByLearner_LearnerIdAndVideo_Id(learnerId, videoId)
                .orElse(LearnerVideoProgress.builder()
                        .learner(learner)
                        .video(video)
                        .completed(false)
                        .build());

        progress.setCompleted(true);
        progressRepository.save(progress);
    }

    public List<Long> getCompletedVideoIds(Long learnerId, Long courseId) {
        return progressRepository.findByLearner_LearnerIdAndVideo_Course_CourseId(learnerId, courseId).stream()
                .filter(LearnerVideoProgress::isCompleted)
                .map(progress -> progress.getVideo().getId())
                .collect(Collectors.toList());
    }

    public boolean isVideoCompleted(Long learnerId, Long videoId) {
        return progressRepository.existsByLearner_LearnerIdAndVideo_Id(learnerId, videoId);
    }

    public long countCompletedVideos(Long learnerId, Long courseId) {
        return progressRepository.countByLearner_LearnerIdAndVideo_Course_CourseIdAndCompletedTrue(learnerId, courseId);
    }

    public List<Video> getAllVideosForCourse(Long courseId) {
        return videoRepository.findByCourse_CourseIdOrderBySequenceNumberAsc(courseId);
    }
}


