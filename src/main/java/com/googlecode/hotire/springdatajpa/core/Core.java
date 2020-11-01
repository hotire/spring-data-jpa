package com.googlecode.hotire.springdatajpa.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Core {
    @Id @GeneratedValue
    private Long id;
}
