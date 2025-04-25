package com.ust.LMS.chat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatThread {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long learnerId;

    @Enumerated(EnumType.STRING)
    private ChatCategory category;

    @OneToMany(mappedBy = "thread", cascade = CascadeType.ALL)
    private List<ChatMessage> messages;
}