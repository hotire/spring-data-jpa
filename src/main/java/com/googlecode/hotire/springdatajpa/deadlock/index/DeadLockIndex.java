package com.googlecode.hotire.springdatajpa.deadlock.index;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DeadLockIndex {
    @Id
    private Long id;
}
