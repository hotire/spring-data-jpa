package com.googlecode.hotire.springdatajpa.core.transaction;

import org.springframework.transaction.NoTransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @see TransactionAspectSupport
 */
public class TransactionAspectSupportCore {

    /**
     * @see TransactionAspectSupport#currentTransactionStatus()
     */
    public static TransactionStatus currentTransactionStatus() throws NoTransactionException {
        return TransactionAspectSupport.currentTransactionStatus();
    }
}
