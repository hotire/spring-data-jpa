package com.googlecode.hotire.springdatajpa.core.transaction;

import com.googlecode.hotire.springdatajpa.core.Core;
import com.googlecode.hotire.springdatajpa.core.CoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
@SpringBootTest
class TransactionAspectSupportCoreTest {

    @Autowired
    private CoreRepository coreRepository;

    @Autowired
    private TransactionDelegator delegator;

    @Test
    void test() throws Exception {
        log.info("no transaction, isActualTransactionActive : {}", TransactionSynchronizationManager.isActualTransactionActive());

        delegator.transaction(() -> {
            log.info("transaction, isActualTransactionActive : {}", TransactionSynchronizationManager.isActualTransactionActive());
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
                @Override
                public void afterCommit() {
                    System.out.println(TransactionAspectSupportCore.currentTransactionStatus());
                }
            });
            return coreRepository.saveAndFlush(new Core());
        });
    }
}