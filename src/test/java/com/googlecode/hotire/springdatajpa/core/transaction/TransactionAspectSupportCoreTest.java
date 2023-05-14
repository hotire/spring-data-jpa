package com.googlecode.hotire.springdatajpa.core.transaction;

import com.googlecode.hotire.springdatajpa.core.Core;
import com.googlecode.hotire.springdatajpa.core.CoreRepository;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.NoTransactionException;
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
        final AtomicReference<TransactionStatus> status = new AtomicReference();
        delegator.transaction(() -> {
            status.set(TransactionAspectSupportCore.currentTransactionStatus());
            printTransaction(status.get());
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
                @Override
                public void afterCommit() {
                    log.info("afterCommit");
                    printTransaction(status.get());
                    TransactionSynchronizationManager.registerSynchronization(
                        new TransactionSynchronization() {
                            @Override
                            public void afterCommit() {
                                log.info("inner afterCommit");
                                printTransaction(status.get());
                            }
                        });
//                    TransactionAspectSupportCore.currentTransactionStatus(); // throw Exception
                }
            });
            return coreRepository.saveAndFlush(new Core());
        });
        printTransaction(status.get());
    }

    Optional<TransactionStatus> currentTransactionStatus() {
        try {
            return Optional.of(TransactionAspectSupportCore.currentTransactionStatus());
        } catch (NoTransactionException e) {
            log.warn("[NoTransactionException] message: {}", e.getMessage(), e);
            return Optional.empty();
        }
    }

    void printTransaction(TransactionStatus status) {
        log.info("currentTransactionStatus : {}", status);
        log.info("isNewTransaction : {}", status.isNewTransaction());
        log.info("hasSavepoint : {}", status.hasSavepoint());
        log.info("isRollbackOnly : {}", status.isRollbackOnly());
        log.info("isCompleted : {}", status.isCompleted());
        log.info("currentTransactionStatus : {}", currentTransactionStatus().orElse(null));
        log.info("isActualTransactionActive : {}", TransactionSynchronizationManager.isActualTransactionActive());
    }
}