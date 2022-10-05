package com.googlecode.hotire.springdatajpa.core.data_source.hikari;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.pool.HikariPool;

/**
 * @see HikariDataSource
 */
public class HikariDataSourceCore {

    private volatile HikariPool pool;
}
