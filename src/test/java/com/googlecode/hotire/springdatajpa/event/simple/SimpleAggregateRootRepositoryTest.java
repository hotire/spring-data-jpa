package com.googlecode.hotire.springdatajpa.event.simple;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;

@SpringBootTest
class SimpleAggregateRootRepositoryTest {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Test
    void event() {
        publisher.publishEvent(new SimpleAggregateRoot());
    }
}