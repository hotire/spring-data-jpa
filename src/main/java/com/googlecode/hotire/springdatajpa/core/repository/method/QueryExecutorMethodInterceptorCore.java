package com.googlecode.hotire.springdatajpa.core.repository.method;

import java.lang.reflect.Method;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.data.repository.query.RepositoryQuery;
import org.springframework.data.util.Pair;

/**
 * @see org.springframework.data.repository.core.support.QueryExecutorMethodInterceptor
 */
@RequiredArgsConstructor
public class QueryExecutorMethodInterceptorCore {

    /**
     * @see org.springframework.data.repository.core.support.QueryExecutorMethodInterceptor#queries
     */
    private final Map<Method, RepositoryQuery> queries;


    /**
     * @see QueryExecutorMethodInterceptor#lookupQuery(Method, RepositoryInformation, QueryLookupStrategy, ProjectionFactory)
     */
    private Pair<Method, RepositoryQuery> lookupQuery(Method method, RepositoryInformation information,
        QueryLookupStrategy strategy, ProjectionFactory projectionFactory) {
        return null;
    }
}
