package com.googlecode.hotire.springdatajpa.core.immutable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImmutableEntityRepository extends JpaRepository<ImmutableEntity, Long> {

}
