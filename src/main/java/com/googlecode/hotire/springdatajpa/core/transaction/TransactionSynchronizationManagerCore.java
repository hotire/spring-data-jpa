package com.googlecode.hotire.springdatajpa.core.transaction;

import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @see TransactionSynchronizationManager
 */
public class TransactionSynchronizationManagerCore {

    /**
     * @see TransactionSynchronizationManager#isCurrentTransactionReadOnly()
     */
    public static boolean isCurrentTransactionReadOnly() {
        return true;
    }
}
