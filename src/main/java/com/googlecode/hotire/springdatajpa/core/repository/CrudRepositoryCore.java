package com.googlecode.hotire.springdatajpa.core.repository;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.CrudRepository;


/**
 * @see CrudRepository
 */
public interface CrudRepositoryCore<T> {

  /**
   * @see CrudRepository#deleteAll(Iterable)
   * @see SimpleJpaRepository#deleteAll(Iterable)
   */
  void deleteAll(Iterable<? extends T> entities);

}
