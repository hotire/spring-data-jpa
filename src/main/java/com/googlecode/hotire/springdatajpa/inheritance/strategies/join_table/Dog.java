package com.googlecode.hotire.springdatajpa.inheritance.strategies.join_table;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
@DiscriminatorValue("DOG")
public class Dog extends Animal {

}
