package com.googlecode.hotire.springdatajpa.flush;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class FlushEntityTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Transactional
    void auto() {
        final FlushEntity flushEntity = new FlushEntity();
        entityManager.setFlushMode(FlushModeType.AUTO);
        entityManager.persist(flushEntity);
        entityManager.createQuery("select f from FlushEntity f", FlushEntity.class).getResultList();
    }
}