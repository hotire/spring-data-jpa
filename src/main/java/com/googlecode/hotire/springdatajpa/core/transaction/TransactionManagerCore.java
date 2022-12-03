package com.googlecode.hotire.springdatajpa.core.transaction;

import org.hibernate.TransactionException;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.lang.Nullable;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;
import org.springframework.transaction.support.DefaultTransactionStatus;
import org.springframework.transaction.support.TransactionSynchronizationManager;

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

    /**
     * @see AbstractPlatformTransactionManager#doBegin(Object, TransactionDefinition)
     */
    protected void doBegin(final Object transaction, final TransactionDefinition definition)
            throws TransactionException {

    }

    /**
     * @see AbstractPlatformTransactionManager#doGetTransaction()
     */
    protected Object doGetTransaction() throws TransactionException {
        return null;
    }

    /**
     * @see AbstractPlatformTransactionManager#doCommit(DefaultTransactionStatus)
     */
    protected void doCommit(final DefaultTransactionStatus status) throws TransactionException {

    }

    /**
     * @see AbstractPlatformTransactionManager#doRollback(DefaultTransactionStatus) 
     */
    protected void doRollback(final DefaultTransactionStatus status) throws TransactionException {

    }

    /**
     * @see AbstractPlatformTransactionManager#prepareTransactionStatus(TransactionDefinition, Object, boolean, boolean, boolean, Object)
     */
    protected final DefaultTransactionStatus prepareTransactionStatus(
        TransactionDefinition definition, @Nullable Object transaction, boolean newTransaction,
        boolean newSynchronization, boolean debug, @Nullable Object suspendedResources) {
        DefaultTransactionStatus status = newTransactionStatus(
            definition, transaction, newTransaction, newSynchronization, debug, suspendedResources);
        prepareSynchronization(status, definition);
        return status;
    }

    /**
     * @see AbstractPlatformTransactionManager#newTransactionStatus(TransactionDefinition, Object, boolean, boolean, boolean, Object) 
     */
    protected DefaultTransactionStatus newTransactionStatus(
        TransactionDefinition definition, @Nullable Object transaction, boolean newTransaction,
        boolean newSynchronization, boolean debug, @Nullable Object suspendedResources) {

        boolean actualNewSynchronization = newSynchronization &&
            !TransactionSynchronizationManager.isSynchronizationActive();
        return new DefaultTransactionStatus(
            transaction, newTransaction, actualNewSynchronization,
            definition.isReadOnly(), debug, suspendedResources);
    }

    /**
     * @see AbstractPlatformTransactionManager#prepareSynchronization(DefaultTransactionStatus, TransactionDefinition)
     */
    protected void prepareSynchronization(DefaultTransactionStatus status, TransactionDefinition definition) {
        TransactionSynchronizationManager.setCurrentTransactionReadOnly(definition.isReadOnly());
    }

    /**
     * @see AbstractPlatformTransactionManager#getTransaction(TransactionDefinition)
     */
    public final org.springframework.transaction.TransactionStatus getTransaction(@Nullable TransactionDefinition definition) {
        return null;
    }
}
