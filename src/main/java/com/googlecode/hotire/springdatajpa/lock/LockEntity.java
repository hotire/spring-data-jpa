package com.googlecode.hotire.springdatajpa.lock;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class LockEntity {
    @Id @GeneratedValue
    private Long id;
}
