package com.googlecode.hotire.springdatajpa.core;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class Core {
    @Id @GeneratedValue
    private Long id;
}
