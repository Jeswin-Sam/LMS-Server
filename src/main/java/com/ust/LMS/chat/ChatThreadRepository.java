package com.ust.LMS.chat;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChatThreadRepository extends JpaRepository<ChatThread, Long> {
    Optional<ChatThread> findByLearnerIdAndCategory(Long learnerId, ChatCategory category);
}
