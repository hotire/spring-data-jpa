package com.googlecode.hotire.springdatajpa.lock;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class LockEntityRepositoryTest {

    @Autowired
    private LockEntityRepository repository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void findByIdForUpdate() {
        final LockEntity result = repository.saveAndFlush(new LockEntity());

        entityManager.find(LockEntity.class, result.getId(), LockModeType.PESSIMISTIC_WRITE);
        repository.findByIdForUpdate(result.getId());
    }

}