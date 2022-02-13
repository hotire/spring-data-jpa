package com.googlecode.hotire.springdatajpa.event.simple;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpleAggregateRootRepository extends JpaRepository<SimpleAggregateRoot, Long> {
}
