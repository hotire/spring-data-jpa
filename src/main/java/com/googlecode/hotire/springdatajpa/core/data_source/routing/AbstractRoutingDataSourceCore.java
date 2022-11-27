package com.googlecode.hotire.springdatajpa.core.data_source.routing;

import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @see AbstractRoutingDataSource
 */
public class AbstractRoutingDataSourceCore {

    /**
     * @see AbstractRoutingDataSource#targetDataSources
     */
    private Map<Object, Object> targetDataSources;

    /**
     * @see AbstractRoutingDataSource#determineTargetDataSource()
     */
    protected DataSource determineTargetDataSource() {
        return null;
    }

}
