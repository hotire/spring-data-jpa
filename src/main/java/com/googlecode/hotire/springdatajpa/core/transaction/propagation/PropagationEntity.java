package com.googlecode.hotire.springdatajpa.core.transaction.propagation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PropagationEntity {
    @Id @GeneratedValue
    private Long id;
}
