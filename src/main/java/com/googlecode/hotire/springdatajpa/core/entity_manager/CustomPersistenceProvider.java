package com.googlecode.hotire.springdatajpa.core.entity_manager;

import javax.persistence.spi.PersistenceProvider;

import org.hibernate.jpa.HibernatePersistenceProvider;

import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;

@RequiredArgsConstructor
public class CustomPersistenceProvider implements PersistenceProvider {

    @Delegate
    private final HibernatePersistenceProvider hibernatePersistenceProvider;
}
