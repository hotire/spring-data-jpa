package com.googlecode.hotire.springdatajpa.event;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Item extends AggregateEventPublisher<Item> {

    @GeneratedValue
    @Id
    private Long id;

    @Override
    public EventCallbackAware<Item> getEvent() {
        return new ItemEvent(this);
    }
}


