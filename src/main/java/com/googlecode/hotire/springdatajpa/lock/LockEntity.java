package com.googlecode.hotire.springdatajpa.lock;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LockEntity {
    @Id @GeneratedValue
    private Long id;
}
