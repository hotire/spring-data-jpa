package com.googlecode.hotire.springdatajpa.audit;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public abstract class Entity<ID extends Serializable> {
    @Id @GeneratedValue
    private ID id;
}
