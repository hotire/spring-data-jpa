package com.googlecode.hotire.springdatajpa.core.query;

import org.hibernate.engine.query.spi.HQLQueryPlan;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.query.internal.QueryImpl;

public class CustomQueryImpl<R> extends QueryImpl<R> {

    public CustomQueryImpl(SharedSessionContractImplementor producer,
        HQLQueryPlan hqlQueryPlan, String queryString) {
        super(producer, hqlQueryPlan, queryString);
    }

//    public CustomQueryImpl(final SharedSessionContractImplementor producer, final ParameterMetadata parameterMetadata, final String queryString) {
//        super(producer, parameterMetadata, queryString);
//    }
}
