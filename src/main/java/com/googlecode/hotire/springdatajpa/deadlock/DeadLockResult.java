package com.googlecode.hotire.springdatajpa.deadlock;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DeadLockResult {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer age;
}
