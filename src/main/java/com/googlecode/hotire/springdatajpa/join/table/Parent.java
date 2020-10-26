package com.googlecode.hotire.springdatajpa.join.table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Parent {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String hash;

    @OneToOne
    @JoinTable(name = "PARENT_CHILD",
               joinColumns = @JoinColumn(name = "id") ,
               inverseJoinColumns = @JoinColumn(name = "id"))
    private Child child;
}
