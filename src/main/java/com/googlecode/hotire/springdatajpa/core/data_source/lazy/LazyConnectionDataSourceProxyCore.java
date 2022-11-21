package com.googlecode.hotire.springdatajpa.core.data_source.lazy;

import java.sql.Connection;
import java.sql.SQLException;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

/**
 * @see LazyConnectionDataSourceProxy
 */
public class LazyConnectionDataSourceProxyCore {

    private LazyConnectionDataSourceProxy proxy;

    /**
     * @see LazyConnectionDataSourceProxy#getConnection()
     */
    public Connection getConnection() throws SQLException {
        return proxy.getConnection();
    }

}
