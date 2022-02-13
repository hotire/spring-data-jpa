package com.googlecode.hotire.springdatajpa.event.simple;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.domain.AbstractAggregateRoot;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SimpleAggregateRoot extends AbstractAggregateRoot<SimpleAggregateRoot>{

    @Id @GeneratedValue
    private Long id;

    private String name;

    public SimpleAggregateRoot saved() {
        registerEvent(new SimpleAggregateRoot());
        return this;
    }
}
