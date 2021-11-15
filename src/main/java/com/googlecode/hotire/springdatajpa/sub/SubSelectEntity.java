package com.googlecode.hotire.springdatajpa.sub;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Immutable
@Subselect("SELECT id FROM origin")
public class SubSelectEntity {
    @Id
    private Long id;
}
