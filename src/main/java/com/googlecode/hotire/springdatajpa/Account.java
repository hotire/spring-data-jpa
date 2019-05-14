package com.googlecode.hotire.springdatajpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Account {

  @Id @GeneratedValue
  private Long id;

  private String username;

  private String password;
}
