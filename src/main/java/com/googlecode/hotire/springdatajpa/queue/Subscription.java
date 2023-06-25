package com.googlecode.hotire.springdatajpa.queue;

import com.googlecode.hotire.springdatajpa.queue.Subscription.ComposeId;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.IdClass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

@Data
@IdClass(ComposeId.class)
public class Subscription {
    @Id
    private String consumerId;
    @Id
    private QueueType type;
    private Long offSet;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Data
    public static class ComposeId implements Serializable {
        private String consumerId;
        private QueueType type;
    }
}
