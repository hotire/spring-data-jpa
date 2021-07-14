package com.googlecode.hotire.springdatajpa.event;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.domain.AbstractAggregateRoot;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Book extends AbstractAggregateRoot<Book> implements BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer age;

    public Book publish() {
        registerEvent(EntityEvent.builder().baseBaseEntity(this).build());
        return this;
    }
}
