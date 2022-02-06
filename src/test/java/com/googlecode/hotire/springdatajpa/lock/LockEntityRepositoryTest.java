package com.googlecode.hotire.springdatajpa.lock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class LockEntityRepositoryTest {

    @Autowired
    private LockEntityRepository repository;

    @Test
    void findByIdForUpdate() {
        final LockEntity result = repository.saveAndFlush(new LockEntity());
        repository.findByIdForUpdate(result.getId());
    }
}