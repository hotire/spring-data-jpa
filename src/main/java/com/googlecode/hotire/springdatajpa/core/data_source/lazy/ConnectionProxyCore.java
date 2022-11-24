package com.googlecode.hotire.springdatajpa.core.data_source.lazy;

import java.sql.Connection;
import org.springframework.jdbc.datasource.ConnectionProxy;

/**
 * @see ConnectionProxy
 */
public class ConnectionProxyCore {

    /**
     * @see ConnectionProxy#getTargetConnection()
     */
    public Connection getTargetConnection() {
        return null;
    }

}
