package com.googlecode.hotire.springdatajpa.envers;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnversEntityRepository extends JpaRepository<EnversEntity, Long> {
}
