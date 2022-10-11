package com.googlecode.hotire.springdatajpa.core.transaction.support.ex;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TransactionSynchronizationManagerServiceTest {


    @Autowired
    private TransactionSynchronizationManagerService transactionSynchronizationManagerService;

    @Test
    void save() {
        transactionSynchronizationManagerService.save();;
    }

}