package com.ust.LMS.progress_tracking;

import com.ust.LMS.learner.LearnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/learner/progress")
@RequiredArgsConstructor
public class LearnerProgressController {

    @Autowired private LearnerRepository learnerRepository;

    private final LearnerProgressService progressService;

    // Assumes learnerId is obtained based on authenticated email from Principal

    private Long getLearnerIdFromPrincipal(Principal principal) {
        return learnerRepository.findByEmail(principal.getName())
                .orElseThrow(() -> new RuntimeException("Learner not found"))
                .getLearnerId();
    }

    @PostMapping("/{courseId}/videos/{videoId}/complete")
    public ResponseEntity<?> markVideoComplete(@PathVariable Long courseId,
                                               @PathVariable Long videoId,
                                               Principal principal) {
        Long learnerId = getLearnerIdFromPrincipal(principal);
        progressService.markVideoAsCompleted(learnerId, videoId);
        return ResponseEntity.ok("Video marked complete");
    }

    @GetMapping("/{courseId}/videos")
    public ResponseEntity<List<Long>> getCompletedVideos(@PathVariable Long courseId,
                                                         Principal principal) {
        Long learnerId = getLearnerIdFromPrincipal(principal);
        List<Long> completedVideoIds = progressService.getCompletedVideoIds(learnerId, courseId);
        return ResponseEntity.ok(completedVideoIds);
    }


    @GetMapping("/{courseId}/playlist")
    public ResponseEntity<List<VideoDTO>> getVideoPlaylist(@PathVariable Long courseId,
                                                           Principal principal) {
        Long learnerId = getLearnerIdFromPrincipal(principal);
        List<Long> completedVideoIds = progressService.getCompletedVideoIds(learnerId, courseId);
        List<Video> allVideos = progressService.getAllVideosForCourse(courseId);

        List<VideoDTO> playlist = allVideos.stream().map(video -> {
            boolean locked = video.getSequenceNumber() > completedVideoIds.size() + 1;
            return new VideoDTO(video.getId(), video.getTitle(), video.getYoutubeUrl(), locked);
        }).toList();

        return ResponseEntity.ok(playlist);
    }
}
