package com.googlecode.hotire.springdatajpa.inheritance.strategies.join_table;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
