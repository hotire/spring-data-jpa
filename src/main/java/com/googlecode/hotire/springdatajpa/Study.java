package com.googlecode.hotire.springdatajpa;

import javax.persistence.Entity;
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

  @ManyToOne
  private Account owner;

  public static Study getInstance(String name){
    Study study = new Study();
    study.setName(name);
    return study;
  }
}
