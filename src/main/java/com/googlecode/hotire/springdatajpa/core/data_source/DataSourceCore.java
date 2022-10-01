package com.googlecode.hotire.springdatajpa.core.data_source;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 * @see DataSource
 */
public interface DataSourceCore {

    /**
     * @see DataSource#getConnection()
     */
    Connection getConnection() throws SQLException;

    /**
     * @see DataSource#getConnection(String, String) 
     */
    Connection getConnection(String username, String password)
        throws SQLException;

}
