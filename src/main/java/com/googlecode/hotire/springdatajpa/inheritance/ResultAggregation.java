package com.googlecode.hotire.springdatajpa.inheritance;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.googlecode.hotire.springdatajpa.inheritance.result.Result;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
public abstract class ResultAggregation<T extends Result> {
    @Id
    @GeneratedValue
    private Long id;

    // TODO generic
//    private T result;
}
