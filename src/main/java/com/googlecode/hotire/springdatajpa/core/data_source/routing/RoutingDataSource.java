package com.googlecode.hotire.springdatajpa.core.data_source.routing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
public class RoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        log.info("[determineCurrentLookupKey] isCurrentTransactionReadOnly: {}", TransactionSynchronizationManager.isCurrentTransactionReadOnly() );
        return TransactionSynchronizationManager.isCurrentTransactionReadOnly() ? DataSourceType.READ_ONLY : DataSourceType.READ_WRITE;
    }

    public enum DataSourceType {
        READ_ONLY, READ_WRITE
    }
}
