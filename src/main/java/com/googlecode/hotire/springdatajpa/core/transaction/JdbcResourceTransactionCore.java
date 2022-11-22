package com.googlecode.hotire.springdatajpa.core.transaction;

import java.sql.Connection;
import java.sql.SQLException;
import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.resource.jdbc.internal.LogicalConnectionManagedImpl;
import org.hibernate.resource.transaction.backend.jdbc.spi.JdbcResourceTransaction;

/**
 * @see JdbcResourceTransaction
 * @see LogicalConnectionManagedImpl
 */
public class JdbcResourceTransactionCore {

    private JdbcConnectionAccess jdbcConnectionAccess;

    /**
     * @see JdbcResourceTransactionCore#begin()
     * @see LogicalConnectionManagedImpl#begin()
     */
    public void begin() throws SQLException {
        getConnectionForTransactionManagement();
    }

    /**
     * @see LogicalConnectionManagedImpl#getConnectionForTransactionManagement()
     */
    protected Connection getConnectionForTransactionManagement() throws SQLException {
        return getPhysicalConnection();
    }

    public Connection getPhysicalConnection() throws SQLException {
        return acquireConnectionIfNeeded();
    }

    /**
     * @see LogicalConnectionManagedImpl#acquireConnectionIfNeeded()
     */
    private Connection acquireConnectionIfNeeded() throws SQLException {
        return jdbcConnectionAccess.obtainConnection();
    }
}
