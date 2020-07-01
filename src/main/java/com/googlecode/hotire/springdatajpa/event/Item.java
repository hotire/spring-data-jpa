package com.googlecode.hotire.springdatajpa.event;

import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Item extends AbstractAggregateRoot<Item> {

    @GeneratedValue
    @Id
    private Long id;

    public Item publish() {
        registerEvent(new ItemEvent(this));
        return this;
    }
}


