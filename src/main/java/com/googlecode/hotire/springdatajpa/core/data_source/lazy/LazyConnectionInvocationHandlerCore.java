package com.googlecode.hotire.springdatajpa.core.data_source.lazy;


import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @see org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy.LazyConnectionInvocationHandler
 */
public class LazyConnectionInvocationHandlerCore {

    /**
     * @see org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy.LazyConnectionInvocationHandler#getTargetConnection(Method) 
     */
    private Connection getTargetConnection(Method operation) throws SQLException {
        return null;
    }

}
