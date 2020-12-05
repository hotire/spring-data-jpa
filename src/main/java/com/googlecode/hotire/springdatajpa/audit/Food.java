package com.googlecode.hotire.springdatajpa.audit;

import javax.persistence.Entity;

import lombok.experimental.Accessors;

@Accessors(chain = true)
@Entity
public class Food extends AuditEntity<Long> {
    private String name;
}
