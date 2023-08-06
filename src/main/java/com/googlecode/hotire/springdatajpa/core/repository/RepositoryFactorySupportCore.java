package com.googlecode.hotire.springdatajpa.core.repository;


import java.util.Optional;
import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.support.RepositoryComposition.RepositoryFragments;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.data.repository.query.QueryLookupStrategy.Key;
import org.springframework.data.repository.query.QueryMethodEvaluationContextProvider;
import org.springframework.lang.Nullable;


/**
 * @see RepositoryFactorySupport
 * @see JpaRepositoryFactory
 */
public class RepositoryFactorySupportCore {

    /**
     * @see RepositoryFactorySupport#classLoader
     */
    private ClassLoader classLoader = org.springframework.util.ClassUtils.getDefaultClassLoader();

    /**
     * @see RepositoryFactorySupport#getQueryLookupStrategy(Key, QueryMethodEvaluationContextProvider)
     * @see JpaRepositoryFactory#getQueryLookupStrategy(Key, QueryMethodEvaluationContextProvider) 
     */
    protected Optional<QueryLookupStrategy> getQueryLookupStrategy(@Nullable Key key,
        QueryMethodEvaluationContextProvider evaluationContextProvider) {
        return Optional.empty();
    }

    /**
     * @see RepositoryFactorySupport#getRepository(Class, RepositoryFragments) 
     * @see ProxyFactory#addAdvice(Advice) 
     */
    public <T> T getRepository(Class<T> repositoryInterface, RepositoryFragments fragments) {
        ProxyFactory result = new ProxyFactory();
        T repository = (T) result.getProxy(classLoader);
        return repository;
    }
}
