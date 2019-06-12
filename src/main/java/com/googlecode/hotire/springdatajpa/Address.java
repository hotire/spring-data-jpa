package com.googlecode.hotire.springdatajpa;


import javax.persistence.Embeddable;

@Embeddable
public class Address {
  private String city;
  private String state;
}
