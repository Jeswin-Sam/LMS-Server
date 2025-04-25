package com.ust.LMS.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService service;

    @GetMapping("/{learnerId}/{category}")
    public List<ChatMessage> getMessages(@PathVariable Long learnerId, @PathVariable ChatCategory category) {
        return service.getMessages(learnerId, category);
    }

    @PostMapping("/{learnerId}/{category}")
    public ChatMessage sendMessage(@PathVariable Long learnerId, @PathVariable ChatCategory category,
                                   @RequestBody ChatMessageRequest request) {
        return service.sendMessage(learnerId, category, request.getMessage(), request.getSender());
    }
}
