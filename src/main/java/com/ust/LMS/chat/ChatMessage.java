package com.ust.LMS.chat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "thread_id")
    private ChatThread thread;

    private String message;

    @Enumerated(EnumType.STRING)
    private SenderType sender;

    @Temporal(TemporalType.TIMESTAMP)
    private Date sentAt;
}

