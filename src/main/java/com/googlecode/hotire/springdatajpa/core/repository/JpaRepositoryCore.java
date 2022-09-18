package com.googlecode.hotire.springdatajpa.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;


/**
 * @see JpaRepository
 * @see SimpleJpaRepository
 */
public interface JpaRepositoryCore<T> {

  /**
   * @see JpaRepository#deleteInBatch(Iterable) 
   * @see SimpleJpaRepository#deleteInBatch(Iterable) 
   */
  void deleteInBatch(Iterable<T> entities);

}
