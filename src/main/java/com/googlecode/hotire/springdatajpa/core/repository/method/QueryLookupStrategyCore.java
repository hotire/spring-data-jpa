package com.googlecode.hotire.springdatajpa.core.repository.method;

import java.lang.reflect.Method;
import javax.persistence.EntityManager;
import org.springframework.data.jpa.repository.query.JpaQueryMethod;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.repository.core.NamedQueries;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.data.repository.query.RepositoryQuery;


/**
 * @see QueryLookupStrategy
 * @see org.springframework.data.jpa.repository.query.JpaQueryLookupStrategy.AbstractQueryLookupStrategy
 * @see org.springframework.data.jpa.repository.query.JpaQueryLookupStrategy.CreateQueryLookupStrategy
 * @see org.springframework.data.jpa.repository.query.JpaQueryLookupStrategy.DeclaredQueryLookupStrategy
 * @see org.springframework.data.jpa.repository.query.JpaQueryLookupStrategy.CreateIfNotFoundQueryLookupStrategy
 *
 * @see QueryLookupStrategy.Key
 *
 * Key 기본전략은 CREATE_IF_NOT_FOUND 으로 CreateIfNotFoundQueryLookupStrategy 사용된다.
 *
 */
public interface QueryLookupStrategyCore {
    
    /**
     * @see QueryLookupStrategy#resolveQuery(Method, RepositoryMetadata, ProjectionFactory, NamedQueries) 
     * @see org.springframework.data.jpa.repository.query.JpaQueryLookupStrategy.AbstractQueryLookupStrategy#resolveQuery(Method, RepositoryMetadata, ProjectionFactory, NamedQueries)  
     * @see org.springframework.data.jpa.repository.query.JpaQueryLookupStrategy.CreateQueryLookupStrategy#resolveQuery(JpaQueryMethod, EntityManager, NamedQueries)
     * @see org.springframework.data.jpa.repository.query.JpaQueryLookupStrategy.DeclaredQueryLookupStrategy#resolveQuery(JpaQueryMethod, EntityManager, NamedQueries)
     * @see org.springframework.data.jpa.repository.query.JpaQueryLookupStrategy.CreateIfNotFoundQueryLookupStrategy#resolveQuery(JpaQueryMethod, EntityManager, NamedQueries)
     */
    RepositoryQuery resolveQuery(
        Method method, RepositoryMetadata metadata, ProjectionFactory factory,
        NamedQueries namedQueries);
}
