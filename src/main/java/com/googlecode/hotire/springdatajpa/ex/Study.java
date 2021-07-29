package com.googlecode.hotire.springdatajpa.ex;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Study {

  @Id @GeneratedValue
  private Long id;

  private String name;

  @ManyToOne(fetch = FetchType.EAGER)
  private Account owner;

  public static Study createInstance(final String name){
    final Study study = new Study();
    study.setName(name);
    return study;
  }
}
