package com.googlecode.hotire.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@Entity
@NoArgsConstructor
public class Account {

  @Id @GeneratedValue
  private Long id;

  private String username;

  private String password;

  private Integer age;

  public Account(String username) {
    this.username = username;
  }

  @Embedded
  @AttributeOverrides({
    @AttributeOverride(name = "city", column = @Column(name = "home_city")),
    @AttributeOverride(name = "state", column = @Column(name = "home_state"))
  })
  private Address homeAddress;

  @Embedded
  @AttributeOverrides({
    @AttributeOverride(name = "city", column = @Column(name = "office_city")),
    @AttributeOverride(name = "state", column = @Column(name = "office_state"))
  })
  private Address officeAddress;

  @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Set<Study> studies = new HashSet<>();

  public Account addStudy(Study study) {
    this.getStudies().add(study);
    study.setOwner(this);
    return this;
  }

  public Account remove(Study study) {
    this.getStudies().remove(study);
    study.setOwner(null);
    return this;
  }
}
