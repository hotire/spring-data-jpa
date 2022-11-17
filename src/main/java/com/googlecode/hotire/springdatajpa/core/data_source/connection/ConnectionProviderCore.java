package com.googlecode.hotire.springdatajpa.core.connection;


import java.sql.Connection;
import java.sql.SQLException;
import org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

/**
 * @see ConnectionProvider
 * @see DatasourceConnectionProviderImpl
 */
public interface ConnectionProviderCore {

    /**
     * @see ConnectionProvider#getConnection()
     * @see DatasourceConnectionProviderImpl#getConnection()
     */
    Connection getConnection() throws SQLException;
}
