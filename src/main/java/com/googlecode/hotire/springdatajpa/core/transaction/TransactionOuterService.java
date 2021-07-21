package com.googlecode.hotire.springdatajpa.core.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class TransactionOuterService {
    private final TransactionRepository transactionRepository;

    private final TransactionProxyService transactionProxyService;

    public void service() {
        try {
            transactionProxyService.run(() -> {
                transactionRepository.save(new Transaction());
                throw new RuntimeException("rollback");
            });
        } catch (final RuntimeException e) {
            log.error(e.getMessage(), e);
        }
    }
}
