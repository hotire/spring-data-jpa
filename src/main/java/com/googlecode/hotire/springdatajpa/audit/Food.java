package com.googlecode.hotire.springdatajpa.audit;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
@Entity
public class Food extends AuditEntity<Long> {
    private String name;
}
