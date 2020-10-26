package com.googlecode.hotire.springdatajpa.join.table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Child {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String hash;
}
