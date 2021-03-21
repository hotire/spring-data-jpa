package com.googlecode.hotire.springdatajpa.core.transaction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
