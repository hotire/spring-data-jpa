package com.googlecode.hotire.springdatajpa.inheritance.strategies.join_table;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
public class Animal {
    @Id
    private Long id;
    private String species;
    private String type;
    private String animalId;
}
