package com.googlecode.hotire.springdatajpa.fulltext;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Article {
    @Id @GeneratedValue
    private Long id;
}
