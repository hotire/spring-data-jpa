package com.googlecode.hotire.springdatajpa.event;

import static org.springframework.transaction.event.TransactionPhase.AFTER_ROLLBACK;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EntityListener {

    @EventListener
    public void consume(final EntityEvent entityEvent) {
        log.info("event : {}", entityEvent);
    }

    @TransactionalEventListener(phase = AFTER_ROLLBACK)
    public void consume(final ItemEvent event) {
        log.info("event : {}", event);
        event.getConsumer().accept(event.getItem());
    }

}
