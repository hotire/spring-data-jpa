package com.googlecode.hotire.springdatajpa.core.data_source.lazy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.ConnectionProxy;

class ConnectionProxyCoreTest {

    @Test
    void create() {
        final Connection proxy = (Connection) Proxy.newProxyInstance(
            this.getClass().getClassLoader(),
            new Class<?>[]{ ConnectionProxy.class},
            new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    return method.getName();
                }
            }
        );
    }

}