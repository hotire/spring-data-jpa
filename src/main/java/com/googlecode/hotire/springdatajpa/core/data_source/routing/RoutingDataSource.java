package com.googlecode.hotire.springdatajpa.core.data_source.routing;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class RoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return TransactionSynchronizationManager.isCurrentTransactionReadOnly() ? DataSourceType.READ_ONLY : DataSourceType.READ_WRITE;
    }

    public enum DataSourceType {
        READ_ONLY, READ_WRITE
    }
}
