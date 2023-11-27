package com.googlecode.hotire.springdatajpa.core.transaction;

import org.springframework.lang.Nullable;
import org.springframework.transaction.NoTransactionException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;

/**
 * @see TransactionAspectSupport
 *
 * Transaction 동작 원리
 * @see TransactionAspectSupport#createTransactionIfNecessary(PlatformTransactionManager, TransactionAttribute, String)
 * @see AbstractPlatformTransactionManager#getTransaction(TransactionDefinition)
 */
public class TransactionAspectSupportCore {

    private AbstractPlatformTransactionManager manager;

    /**
     * @see TransactionAspectSupport#currentTransactionStatus()
     */
    public static TransactionStatus currentTransactionStatus() throws NoTransactionException {
        return TransactionAspectSupport.currentTransactionStatus();
    }

    /**
     * @see TransactionAspectSupport#createTransactionIfNecessary(PlatformTransactionManager, TransactionAttribute, String)
     */
    protected Object createTransactionIfNecessary(@Nullable PlatformTransactionManager tm,
        @Nullable TransactionAttribute txAttr, final String joinpointIdentification) {
        manager.getTransaction(txAttr);
        return null;

    }
}
