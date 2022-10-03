package com.googlecode.hotire.springdatajpa.core.data_source;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.AbstractDataSource;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @see DataSource
 * @see AbstractDataSource
 * @see HikariDataSource
 */
public interface DataSourceCore {

    /**
     * @see DataSource#getConnection()
     * @see HikariDataSource#getConnection()
     */
    Connection getConnection() throws SQLException;

    /**
     * @see DataSource#getConnection(String, String)
     * @see HikariDataSource#getConnection(String, String)
     */
    Connection getConnection(String username, String password)
        throws SQLException;

}
