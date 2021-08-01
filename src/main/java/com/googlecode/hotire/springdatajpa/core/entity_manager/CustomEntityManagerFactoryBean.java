package com.googlecode.hotire.springdatajpa.core.entity_manager;

import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.spi.PersistenceProvider;

import org.springframework.orm.jpa.AbstractEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

/**
 * @see LocalContainerEntityManagerFactoryBean
 */
public class CustomEntityManagerFactoryBean extends AbstractEntityManagerFactoryBean {
    @Override
    protected EntityManagerFactory createNativeEntityManagerFactory() throws PersistenceException {
        final PersistenceProvider provider = getPersistenceProvider();
        return Optional.ofNullable(provider)
                       .map(it -> it.createEntityManagerFactory(getPersistenceUnitName(), getJpaPropertyMap()))
                       .orElse(null);
    }
}
