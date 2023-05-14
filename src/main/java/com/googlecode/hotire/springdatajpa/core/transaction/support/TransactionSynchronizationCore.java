package com.googlecode.hotire.springdatajpa.core.transaction.support;

import org.springframework.transaction.support.TransactionSynchronization;

/** 
 * @see TransactionSynchronization
 */
public class TransactionSynchronizationCore {

    /**
     * @see TransactionSynchronization#afterCompletion(int) 
     */
    void afterCompletion(int status) {
    }
}
