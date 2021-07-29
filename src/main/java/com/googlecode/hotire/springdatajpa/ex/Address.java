package com.googlecode.hotire.springdatajpa.ex;

import javax.persistence.Embeddable;

import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class Address {
  private String city;
  private String state;

  public Address(final String city, final String state) {
    this.city = city;
    this.state = state;
  }
}
