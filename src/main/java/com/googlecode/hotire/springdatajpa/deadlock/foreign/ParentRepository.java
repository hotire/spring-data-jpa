package com.googlecode.hotire.springdatajpa.deadlock.foreign;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<DeadLockParent, Long> {
}
