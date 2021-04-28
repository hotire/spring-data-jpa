package com.googlecode.hotire.springdatajpa.exists;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExistsEntityRepository extends JpaRepository<ExistsEntity, Long> {
    boolean existsByName(String name);
}
