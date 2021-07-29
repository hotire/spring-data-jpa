package com.googlecode.hotire.springdatajpa.json;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JsonEntityRepository extends JpaRepository<JsonEntity, Long>, CustomizedJsonEntityRepository {
}
