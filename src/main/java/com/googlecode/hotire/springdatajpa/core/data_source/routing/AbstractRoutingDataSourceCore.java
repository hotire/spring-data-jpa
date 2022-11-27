package com.googlecode.hotire.springdatajpa.core.data_source.routing;

import javax.sql.DataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @see AbstractRoutingDataSource
 */
public class AbstractRoutingDataSourceCore {

    /**
     * @see AbstractRoutingDataSource#determineTargetDataSource()
     */
    protected DataSource determineTargetDataSource() {
        return null;
    }

}
