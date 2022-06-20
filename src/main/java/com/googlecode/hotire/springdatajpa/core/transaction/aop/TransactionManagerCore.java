package com.googlecode.hotire.springdatajpa.core.transaction.aop;

import org.hibernate.TransactionException;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;

/**
 * @see TransactionManager
 * @see PlatformTransactionManager
 * @see AbstractPlatformTransactionManager
 * @see JpaTransactionManager
 */
public class TransactionManagerCore {

    /**
     * @see PlatformTransactionManager#commit(org.springframework.transaction.TransactionStatus)
     * @see AbstractPlatformTransactionManager#commit(org.springframework.transaction.TransactionStatus)
     */
    void commit(final TransactionStatus status) throws TransactionException {

    }
}
