package com.googlecode.hotire.springdatajpa.inheritance.strategies.table_per_class;

import javax.persistence.Entity;

@Entity
public class TablePerClassB extends TablePerClass {
    private String nameB;
}
