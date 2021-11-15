package com.googlecode.hotire.springdatajpa.sub;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Origin {
    @Id
    private Long id;
}
