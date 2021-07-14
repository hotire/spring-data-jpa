package com.googlecode.hotire.springdatajpa.deadlock;

import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@ToString
@Setter
@Getter
@Entity
public class DeadLock {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToOne(fetch = FetchType.LAZY, optional = true, cascade=CascadeType.ALL)
    private DeadLockResult result;

    public DeadLockResult getResult() {
        return Optional.ofNullable(result).orElseGet(DeadLockResult::new);
    }
}
