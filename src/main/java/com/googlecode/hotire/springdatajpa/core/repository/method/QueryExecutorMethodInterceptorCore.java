package com.googlecode.hotire.springdatajpa.core.repository.method;

import java.lang.reflect.Method;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.data.repository.query.RepositoryQuery;
import org.springframework.data.util.Pair;
import org.springframework.data.repository.core.support.RepositoryFactorySupport.QueryExecutorMethodInterceptor;

/**
 * @see QueryExecutorMethodInterceptor
 */
public class QueryExecutorMethodInterceptorCore {


    /**
     * @see QueryExecutorMethodInterceptor#lookupQuery(Method, RepositoryInformation, QueryLookupStrategy, ProjectionFactory)
     */
    private Pair<Method, RepositoryQuery> lookupQuery(Method method, RepositoryInformation information,
        QueryLookupStrategy strategy, ProjectionFactory projectionFactory) {
        return null;
    }
}
