package com.googlecode.hotire.springdatajpa.core.repository;

import static org.springframework.data.jpa.repository.query.QueryUtils.DELETE_ALL_QUERY_STRING;
import static org.springframework.data.jpa.repository.query.QueryUtils.applyAndBind;
import static org.springframework.data.jpa.repository.query.QueryUtils.getQueryString;

import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;


/**
 * @see JpaRepository
 * @see SimpleJpaRepository
 */
@RequiredArgsConstructor
public class JpaRepositoryCore<T> {

  private final JpaEntityInformation<T, ?> entityInformation;
  private final EntityManager em;

  /**
   * @see JpaRepository#deleteInBatch(Iterable) 
   * @see SimpleJpaRepository#deleteInBatch(Iterable) 
   */
  void deleteInBatch(Iterable<T> entities) {
    applyAndBind(getQueryString(DELETE_ALL_QUERY_STRING, entityInformation.getEntityName()), entities, em)
        .executeUpdate();
  }

}
