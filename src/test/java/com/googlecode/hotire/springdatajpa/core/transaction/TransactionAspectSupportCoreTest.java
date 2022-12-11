package com.googlecode.hotire.springdatajpa.core.transaction;

import com.googlecode.hotire.springdatajpa.core.Core;
import com.googlecode.hotire.springdatajpa.core.CoreRepository;
import java.util.concurrent.atomic.AtomicReference;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionStatus;
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

        final AtomicReference<TransactionStatus> status = new AtomicReference();
        delegator.transaction(() -> {
            log.info("transaction, isActualTransactionActive : {}", TransactionSynchronizationManager.isActualTransactionActive());
            status.set(TransactionAspectSupportCore.currentTransactionStatus());
            print(status.get());
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
                @Override
                public void afterCommit() {
                    log.info("afterCommit, isActualTransactionActive : {}", TransactionSynchronizationManager.isActualTransactionActive());
                    print(status.get());
//                    TransactionAspectSupportCore.currentTransactionStatus(); // throw Exception
                }
            });
            return coreRepository.saveAndFlush(new Core());
        });
        print(status.get());
    }

    void print(TransactionStatus status) {
        log.info("currentTransactionStatus : {}", status);
        log.info("isNewTransaction : {}", status.isNewTransaction());
        log.info("hasSavepoint : {}", status.hasSavepoint());
        log.info("isRollbackOnly : {}", status.isRollbackOnly());
        log.info("isCompleted : {}", status.isCompleted());
    }
}