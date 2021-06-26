package com.googlecode.hotire.springdatajpa.deadlock;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeadLockRepository extends JpaRepository<DeadLock, Long> {
}
