package com.googlecode.hotire.springdatajpa.deadlock.foreign;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Child {
    @Id
    private Long id;

    private Integer age;

    @ManyToOne
    private Parent parent;
}
