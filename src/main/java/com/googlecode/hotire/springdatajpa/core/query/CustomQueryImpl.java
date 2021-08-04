package com.googlecode.hotire.springdatajpa.core.query;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.query.ParameterMetadata;
import org.hibernate.query.internal.QueryImpl;

public class CustomQueryImpl<R> extends QueryImpl<R> {
    public CustomQueryImpl(final SharedSessionContractImplementor producer, final ParameterMetadata parameterMetadata, final String queryString) {
        super(producer, parameterMetadata, queryString);
    }
}
