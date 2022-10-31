package com.googlecode.hotire.springdatajpa.core.transaction.support;

import java.util.Set;
import org.springframework.core.NamedThreadLocal;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @see TransactionSynchronizationManager
 */
public class TransactionSynchronizationManagerCore {

    private static final ThreadLocal<Set<TransactionSynchronization>> synchronizations =
        new NamedThreadLocal<>("Transaction synchronizations");

    /**
     * @see TransactionSynchronizationManager#registerSynchronization(TransactionSynchronization)
     */
    public static void registerSynchronization(TransactionSynchronization synchronization)
        throws IllegalStateException {
        TransactionSynchronizationManager.registerSynchronization(synchronization);
    }

    /**
     * @see TransactionSynchronizationManager#isSynchronizationActive()
     */
    public static boolean isSynchronizationActive() {
        return TransactionSynchronizationManager.isSynchronizationActive();
    }

}
