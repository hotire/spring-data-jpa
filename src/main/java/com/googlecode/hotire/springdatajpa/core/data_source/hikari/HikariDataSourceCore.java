package com.googlecode.hotire.springdatajpa.core.data_source.hikari;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.pool.HikariPool;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @see HikariDataSource
 */
public class HikariDataSourceCore {

    private volatile HikariPool pool;

    /**
     * @see HikariDataSource#getConnection()
     */
    public Connection getConnection() throws SQLException {
        return null;
    }
}
