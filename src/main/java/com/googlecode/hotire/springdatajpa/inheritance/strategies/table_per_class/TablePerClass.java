package com.googlecode.hotire.springdatajpa.inheritance.strategies.table_per_class;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class TablePerClass {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) cannot use IDENTITY
    private Long id;

    private String common;
}
