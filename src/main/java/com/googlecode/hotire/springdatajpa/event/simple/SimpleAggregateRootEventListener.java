package com.googlecode.hotire.springdatajpa.event.simple;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SimpleAggregateRootEventListener {

    @EventListener
    public void listen(final SimpleAggregateRoot root) {
        log.info("SimpleAggregateRoot");
    }
}
