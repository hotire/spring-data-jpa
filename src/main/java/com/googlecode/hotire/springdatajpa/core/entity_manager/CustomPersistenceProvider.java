package com.googlecode.hotire.springdatajpa.core.entity_manager;

import java.util.Map;

import javax.persistence.EntityManagerFactory;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CustomPersistenceProvider extends HibernatePersistenceProvider {

    @Override
    public EntityManagerFactory createEntityManagerFactory(final String persistenceUnitName, final Map properties) {
        log.trace( "Starting createEntityManagerFactory for persistenceUnitName %s", persistenceUnitName );
        final EntityManagerFactoryBuilder builder = getEntityManagerFactoryBuilderOrNull(persistenceUnitName, properties );
        if ( builder == null ) {
            log.trace( "Could not obtain matching EntityManagerFactoryBuilder, returning null" );
            return null;
        }
        else {
            return builder.build();
        }
    }
}
