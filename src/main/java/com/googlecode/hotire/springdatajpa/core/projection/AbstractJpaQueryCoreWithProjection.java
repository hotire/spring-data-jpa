package com.googlecode.hotire.springdatajpa.core.projection;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.query.AbstractJpaQuery;
import org.springframework.data.jpa.repository.query.JpaQueryExecution;
import org.springframework.data.util.Lazy;

/**
 * @see AbstractJpaQuery
 */
@RequiredArgsConstructor
public class AbstractJpaQueryCoreWithProjection {

    /**
     * @see AbstractJpaQuery#execution
     */
    private final Lazy<JpaQueryExecution> execution;


    /**
     * @see AbstractJpaQuery#doExecute(JpaQueryExecution, Object[]) 
     */
    private Object doExecute(JpaQueryExecution execution, Object[] values) {
        return null;
    }

}
