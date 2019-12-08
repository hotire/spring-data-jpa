package com.googlecode.hotire.springdatajpa;


import javax.persistence.Embeddable;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class Address {
  private String city;
  private String state;

  public Address(String city, String state) {
    this.city = city;
    this.state = state;
  }
}
