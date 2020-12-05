package com.googlecode.hotire.springdatajpa.audit;

import javax.persistence.Entity;

@Entity
public class Food extends AuditEntity<Long> {
    private String name;
}
