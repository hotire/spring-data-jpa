package com.googlecode.hotire.springdatajpa.core.transaction;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TransactionInterceptorDecorator implements MethodInterceptor  {
    private final TransactionInterceptor delegate;

    @Override
    public Object invoke(final MethodInvocation invocation) throws Throwable {
        return getDelegate().invoke(invocation);
    }

}
