package com.googlecode.hotire.springdatajpa.core.repository;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class SimpleJpaRepositoryDecorator<T, ID> extends SimpleJpaRepository<T, ID> {
    public SimpleJpaRepositoryDecorator(final JpaEntityInformation<T, ?> entityInformation, final EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    public SimpleJpaRepositoryDecorator(final Class<T> domainClass, final EntityManager em) {
        super(domainClass, em);
    }
}
