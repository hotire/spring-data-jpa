package com.googlecode.hotire.springdatajpa.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class EntityListener {

    @EventListener
    public void consume(EntityEvent entityEvent) {
        log.info("event : {}", entityEvent);
    }

    @EventListener
    public void consume(ItemEvent event) {
        log.info("event : {}", event);
    }

}
