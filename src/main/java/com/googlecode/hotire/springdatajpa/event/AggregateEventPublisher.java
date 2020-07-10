package com.googlecode.hotire.springdatajpa.event;

import org.springframework.data.domain.AbstractAggregateRoot;

public abstract class AggregateEventPublisher<T extends AbstractAggregateRoot<T> & EventPublisher<T>> extends AbstractAggregateRoot<T> implements EventPublisher<T> {

    @Override
    public <T> T publish(final T event) {
        return super.registerEvent(event);
    }
}
