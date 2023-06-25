package com.googlecode.hotire.springdatajpa.queue;

import java.time.LocalDateTime;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

@Data
public class Queue {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long offset;
    @Enumerated(EnumType.STRING)
    private QueueType type;
    private String messageJson;
    @CreatedDate
    private LocalDateTime createdAt;
}
