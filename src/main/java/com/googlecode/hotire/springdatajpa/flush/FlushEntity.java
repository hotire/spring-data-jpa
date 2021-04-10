package com.googlecode.hotire.springdatajpa.flush;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class FlushEntity {
    @Id @GeneratedValue
    private Long id;

    private String name;
}
