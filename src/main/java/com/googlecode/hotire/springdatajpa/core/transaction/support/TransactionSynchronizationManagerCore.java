package com.googlecode.hotire.springdatajpa.core.transaction.support;

import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @see TransactionSynchronizationManager
 */
public class TransactionSynchronizationManagerCore {

    /**
     * @see TransactionSynchronizationManager#registerSynchronization(TransactionSynchronization) 
     */
    public static void registerSynchronization(TransactionSynchronization synchronization)
        throws IllegalStateException {
        TransactionSynchronizationManager.registerSynchronization(synchronization);
    }
}
