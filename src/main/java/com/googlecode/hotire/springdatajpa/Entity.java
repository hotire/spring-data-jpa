package com.googlecode.hotire.springdatajpa;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Setter
@Getter
@MappedSuperclass
public abstract class Entity<ID extends Serializable> {
    @Id @GeneratedValue
    private ID id;
}
