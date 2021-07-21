package com.googlecode.hotire.springdatajpa.core.transaction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

/**
 * https://techblog.woowahan.com/2606/
 * 
 * @see org.springframework.transaction.interceptor.TransactionAspectSupport#completeTransactionAfterThrowing
 *
 */
@Slf4j
@SpringBootTest
class TransactionOuterServiceTest {

    @Autowired
    private TransactionOuterService transactionOuterService;

    @DisplayName("debug")
    @Test
    void service() {
        try {
            transactionOuterService.service();
        } catch (final Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}