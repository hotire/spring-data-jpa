package com.googlecode.hotire.springdatajpa.core.transaction;

import org.hibernate.engine.transaction.internal.TransactionImpl;
import org.hibernate.resource.transaction.backend.jdbc.spi.JdbcResourceTransaction;
import org.hibernate.resource.transaction.spi.TransactionCoordinator.TransactionDriver;
import org.hibernate.resource.transaction.spi.TransactionStatus;

/**
 * @see javax.persistence.EntityTransaction
 * @see TransactionImpl
 */
public class EntityTransactionCore {

    /**
     * @see org.hibernate.resource.transaction.backend.jdbc.internal.JdbcResourceLocalTransactionCoordinatorImpl.TransactionDriverControlImpl
     */
    private TransactionDriver transactionDriverControl = new TransactionDriver() {

        /**
         * @see org.hibernate.resource.jdbc.internal.LogicalConnectionManagedImpl
         */
        private JdbcResourceTransaction jdbcResourceTransaction;

        @Override
        public void begin() {
            jdbcResourceTransaction.begin();
        }

        @Override
        public void commit() {

        }

        @Override
        public void rollback() {

        }

        @Override
        public TransactionStatus getStatus() {
            return null;
        }

        @Override
        public void markRollbackOnly() {

        }
    };

    /**
     * @see TransactionImpl#begin()
     */
    public void begin() {
        transactionDriverControl.begin();
    }
}
