package com.googlecode.hotire.springdatajpa.query.type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Type {
    @Id @GeneratedValue
    private Long id;
    private String name;
}
