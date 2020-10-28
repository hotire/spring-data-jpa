package com.googlecode.hotire.springdatajpa.query.specification;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Content {
    @Id @GeneratedValue
    private Long id;
    private String name;
}
