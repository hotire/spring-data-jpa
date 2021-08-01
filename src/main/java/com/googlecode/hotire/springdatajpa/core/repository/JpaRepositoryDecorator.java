package com.googlecode.hotire.springdatajpa.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;

/**
 * @see JpaRepository
 * @see JpaRepositoryImplementation
 */
@RequiredArgsConstructor
public class JpaRepositoryDecorator<T, ID> implements JpaRepository<T, ID> {

    @Delegate
    private final JpaRepository<T, ID> delegate;
}
