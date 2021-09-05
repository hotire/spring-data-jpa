package com.googlecode.hotire.springdatajpa.inheritance.strategies.join_table;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;

@Data
@Entity
@DiscriminatorValue("CAT")
@PrimaryKeyJoinColumn(name = "animalId")
public class Cat extends Animal {

}