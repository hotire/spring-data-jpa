package com.googlecode.hotire.springdatajpa.inheritance.strategies.join_table;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Long> {
}
