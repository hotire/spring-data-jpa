package com.googlecode.hotire.springdatajpa.core.transaction.support.ex;

import com.googlecode.hotire.springdatajpa.core.transaction.Transaction;
import com.googlecode.hotire.springdatajpa.core.transaction.TransactionRepository;
import com.googlecode.hotire.springdatajpa.core.transaction.support.TransactionSynchronizationManagerCore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionSynchronizationManagerService {

    private final TransactionRepository transactionRepository;

    @Transactional
    public void save() {
        transactionRepository.saveAndFlush(new Transaction());
        TransactionSynchronizationManagerCore.registerSynchronization(
            new TransactionSynchronization() {
                @Override
                public void afterCommit() {
                    log.info("hello afterCommit");
                }
            });
    }
}
