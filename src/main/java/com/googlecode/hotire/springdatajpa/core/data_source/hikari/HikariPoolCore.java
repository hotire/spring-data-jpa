package com.googlecode.hotire.springdatajpa.core.data_source.hikari;

import java.sql.Connection;
import java.sql.SQLException;
import com.zaxxer.hikari.pool.HikariPool;

/**
 * @see HikariPool
 */
public interface HikariPoolCore {

    /**
     * @see HikariPool#getConnection() 
     * @see HikariPool#getConnection(long) () 
     */
    Connection getConnection() throws SQLException;
}
