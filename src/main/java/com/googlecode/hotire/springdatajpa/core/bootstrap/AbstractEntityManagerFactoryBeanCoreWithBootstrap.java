package com.googlecode.hotire.springdatajpa.core.bootstrap;

import javax.persistence.EntityManagerFactory;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.orm.jpa.AbstractEntityManagerFactoryBean;

/**
 * @see AbstractEntityManagerFactoryBean
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
}
