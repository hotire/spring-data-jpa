package com.googlecode.hotire.springdatajpa.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @see JpaRepository
 */
public interface JpaRepositoryCore<T> {

  /**
   * @see JpaRepository#deleteInBatch(Iterable) 
   */
  void deleteInBatch(Iterable<T> entities);

}
