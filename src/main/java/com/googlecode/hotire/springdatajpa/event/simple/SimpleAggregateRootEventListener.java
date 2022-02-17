package com.googlecode.hotire.springdatajpa.event.simple;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import lombok.extern.slf4j.Slf4j;

/**
 * @see org.springframework.beans.factory.config.BeanFactoryPostProcessor
 * @see org.springframework.context.event.EventListenerMethodProcessor
 */
@Slf4j
@Component
public class SimpleAggregateRootEventListener {

    @EventListener
    public void listen(final SimpleAggregateRoot root) {
        log.info("SimpleAggregateRoot");
    }

    /**
     * @see org.springframework.transaction.event.ApplicationListenerMethodTransactionalAdapter
     */
    @TransactionalEventListener
    public void transactionalEventListen(final SimpleAggregateRoot root) {
        log.info("SimpleAggregateRoot");
    }
}
