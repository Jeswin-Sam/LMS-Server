package com.ust.LMS.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatThreadRepository threadRepository;

    @Autowired
    private ChatMessageRepository messageRepository;

    public List<ChatMessage> getMessages(Long learnerId, ChatCategory category) {
        ChatThread thread = threadRepository.findByLearnerIdAndCategory(learnerId, category)
                .orElseThrow(() -> new RuntimeException("Thread not found"));
        return thread.getMessages();
    }

    public ChatMessage sendMessage(Long learnerId, ChatCategory category, String msg, SenderType sender) {
        ChatThread thread = threadRepository.findByLearnerIdAndCategory(learnerId, category)
                .orElseGet(() -> threadRepository.save(new ChatThread(null, learnerId, category, null)));

        ChatMessage message = new ChatMessage();
        message.setThread(thread);
        message.setMessage(msg);
        message.setSender(sender);
        message.setSentAt(new Date());

        return messageRepository.save(message);
    }
}
