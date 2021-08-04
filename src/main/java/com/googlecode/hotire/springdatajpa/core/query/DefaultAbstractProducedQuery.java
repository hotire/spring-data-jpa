package com.googlecode.hotire.springdatajpa.core.query;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.query.ParameterMetadata;
import org.hibernate.query.Query;
import org.hibernate.query.internal.AbstractProducedQuery;
import org.hibernate.query.spi.QueryParameterBindings;
import org.hibernate.type.Type;

public class DefaultAbstractProducedQuery<R> extends AbstractProducedQuery<R> {

    public DefaultAbstractProducedQuery(final SharedSessionContractImplementor producer, final ParameterMetadata parameterMetadata) {
        super(producer, parameterMetadata);
    }

    @Override
    protected boolean isNativeQuery() {
        return false;
    }

    @Override
    protected QueryParameterBindings getQueryParameterBindings() {
        return null;
    }

    @Override
    public String getQueryString() {
        return null;
    }

    @Override
    public Type[] getReturnTypes() {
        return new Type[0];
    }

    @Override
    public Query<R> setEntity(final int position, final Object val) {
        return null;
    }

    @Override
    public Query<R> setEntity(final String name, final Object val) {
        return null;
    }

    @Override
    public String[] getReturnAliases() {
        return new String[0];
    }
}
