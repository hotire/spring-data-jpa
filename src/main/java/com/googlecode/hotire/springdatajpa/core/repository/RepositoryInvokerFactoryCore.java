package com.googlecode.hotire.springdatajpa.core.repository;

import org.springframework.data.repository.support.RepositoryInvoker;
import org.springframework.data.repository.support.RepositoryInvokerFactory;
import org.springframework.data.repository.support.DefaultRepositoryInvokerFactory;

/**
 * @see RepositoryInvokerFactory
 * @see DefaultRepositoryInvokerFactory
 */
public interface RepositoryInvokerFactoryCore {


    /**
     * @see RepositoryInvokerFactory#getInvokerFor(Class) 
     */
    RepositoryInvoker getInvokerFor(Class<?> domainType);
}
