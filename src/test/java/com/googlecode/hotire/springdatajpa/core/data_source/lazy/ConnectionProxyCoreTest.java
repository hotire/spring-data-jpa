package com.googlecode.hotire.springdatajpa.core.data_source.lazy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.ConnectionProxy;

class ConnectionProxyCoreTest {

    @Test
    void create() {
        final Connection expected = mock(Connection.class);
        final ConnectionProxy proxy = (ConnectionProxy) Proxy.newProxyInstance(
            this.getClass().getClassLoader(),
            new Class<?>[]{ ConnectionProxy.class},
            new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if ("getTargetConnection".equals(method.getName())) {
                        return expected;
                    }
                    return method.getName();
                }
            }
        );

        // when
        final Connection result = proxy.getTargetConnection();

        // then
        assertThat(result).isEqualTo(expected);
    }

}