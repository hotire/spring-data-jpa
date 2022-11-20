package com.googlecode.hotire.springdatajpa.core.transaction;

import java.sql.Connection;
import java.sql.SQLException;
import org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.internal.NonContextualJdbcConnectionAccess;

/**
 * @see JdbcConnectionAccess
 * @see NonContextualJdbcConnectionAccess
 */
public class JdbcConnectionAccessCore {

    /**
     * @see DatasourceConnectionProviderImpl;
     */
    private ConnectionProvider connectionProvider = new DatasourceConnectionProviderImpl();

    /**
     * @see JdbcConnectionAccess#obtainConnection()
     * @see NonContextualJdbcConnectionAccess#obtainConnection()
     * @see DatasourceConnectionProviderImpl#getConnection()
     */
    Connection obtainConnection() throws SQLException {
        return connectionProvider.getConnection();
    }
}
