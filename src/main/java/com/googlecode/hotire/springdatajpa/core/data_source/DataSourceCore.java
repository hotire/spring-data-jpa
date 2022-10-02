package com.googlecode.hotire.springdatajpa.core.data_source;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.AbstractDataSource;

/**
 * @see DataSource
 * @see AbstractDataSource
 */
public interface DataSourceCore {

    /**
     * @see DataSource#get   Connection()
     */
    Connection getConnection() throws SQLException;

    /**
     * @see DataSource#getConnection(String, String)
     */
    Connection getConnection(String username, String password)
        throws SQLException;

}
