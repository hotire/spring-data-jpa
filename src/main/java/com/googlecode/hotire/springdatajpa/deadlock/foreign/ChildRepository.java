package com.googlecode.hotire.springdatajpa.deadlock.foreign;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, Long> {
}
