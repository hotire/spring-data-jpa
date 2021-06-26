package com.googlecode.hotire.springdatajpa.deadlock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Import(DeadLockService.class)
class DeadLockServiceTest {

    @Autowired
    private DeadLockService deadLockService;

    @Test
    void save() {
        final DeadLock deadLock = new DeadLock();
        deadLockService.save(deadLock);
    }
}