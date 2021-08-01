package com.googlecode.hotire.springdatajpa.core.entity_manager;

import javax.persistence.EntityManagerFactory;

import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;

@RequiredArgsConstructor
public class EntityManagerFactoryDecorator implements EntityManagerFactory {

    @Delegate
    private final EntityManagerFactory delegate;
}
