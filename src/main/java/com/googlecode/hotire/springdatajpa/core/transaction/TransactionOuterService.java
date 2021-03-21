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
    private final TransactionInnerService transactionInnerService;
    private final TransactionRepository transactionRepository;

    public void service() {
        try {
            transactionRepository.save(new Transaction());
            transactionInnerService.service(RuntimeException::new);
        } catch (RuntimeException e) {
            log.error(e.getMessage(), e);
        }
    }
}
