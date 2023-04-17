package com.googlecode.hotire.springdatajpa.core.jdbc.spi;

import org.hibernate.engine.jdbc.spi.SqlStatementLogger;

/**
 * @see SqlStatementLogger
 */
public class SqlStatementLoggerCore {

    /**
     * @see SqlStatementLogger#logSlowQuery(String, long) 
     */
    public void logSlowQuery(String sql, long startTimeNanos) {
        
    }

}
