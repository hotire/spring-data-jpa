package com.googlecode.hotire.springdatajpa.event;

import static org.springframework.transaction.event.TransactionPhase.AFTER_COMMIT;
import static org.springframework.transaction.event.TransactionPhase.AFTER_COMPLETION;
import static org.springframework.transaction.event.TransactionPhase.AFTER_ROLLBACK;
import static org.springframework.transaction.event.TransactionPhase.BEFORE_COMMIT;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class EntityListener {

    private final ItemRepository itemRepository;

    @EventListener
    public void consume(final EntityEvent entityEvent) {
        log.info("default event : {}", entityEvent);
    }

    @EventListener
    public void consume(final ItemEvent event) {
        log.info("consume : {}", event);
        event.getConsumer().accept(event.getItem());
    }


    @TransactionalEventListener(phase = AFTER_ROLLBACK)
    public void afterRollback(final ItemEvent event) {
        log.info("afterRollback : {}", event);
        event.getConsumer().accept(event.getItem());
        itemRepository.saveAndFlush(new Shield().publish());
    }

    @TransactionalEventListener(phase = AFTER_COMMIT)
    public void afterCommit(final ItemEvent event) {
        log.info("afterCommit : {}", event);
        event.getConsumer().accept(event.getItem());
//        itemRepository.saveAndFlush(new Shield().publish());
    }

    @TransactionalEventListener(phase = AFTER_COMPLETION)
    public void afterComple(final ItemEvent event) {
        log.info("afterComple : {}", event);
        event.getConsumer().accept(event.getItem());
//        itemRepository.saveAndFlush(new Shield().publish());
    }


    @TransactionalEventListener(phase = BEFORE_COMMIT)
    public void beforeCommit(final ItemEvent event) {
        log.info("beforeCommit event : {}", event);
        event.getConsumer().accept(event.getItem());
        itemRepository.saveAndFlush(new Shield().publish());
    }

}
