package com.googlecode.hotire.springdatajpa.event;

import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@javax.persistence.Entity
public class Book extends AbstractAggregateRoot<Book> implements BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Book publish() {
        registerEvent(EntityEvent.builder().baseBaseEntity(this).build());
        return this;
    }
}
