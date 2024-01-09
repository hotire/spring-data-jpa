package com.googlecode.hotire.springdatajpa.core.bootstrap;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.orm.jpa.AbstractEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

/**
 * @see AbstractEntityManagerFactoryBean
 * @see LocalContainerEntityManagerFactoryBean
 */
public class AbstractEntityManagerFactoryBeanCoreWithBootstrap {

    /**
     * @see AbstractEntityManagerFactoryBean#bootstrapExecutor
     */
    private AsyncTaskExecutor bootstrapExecutor;


    /**
     * @see AbstractEntityManagerFactoryBean#buildNativeEntityManagerFactory()
     */
    private EntityManagerFactory buildNativeEntityManagerFactory() {
        return null;
    }


    /**
     * @see AbstractEntityManagerFactoryBean#afterPropertiesSet()
     */
    public void afterPropertiesSet() throws PersistenceException {

    }
}
