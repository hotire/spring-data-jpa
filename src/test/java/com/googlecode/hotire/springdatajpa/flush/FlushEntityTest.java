package com.googlecode.hotire.springdatajpa.flush;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class FlushEntityTest {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * No EntityManager with actual transaction available for current thread - cannot reliably process 'persist' call;
     * nested exception is javax.persistence.TransactionRequiredException:
     *
     * SharedEntityManagerCreator
     * else if (transactionRequiringMethods.contains(method.getName())) {
     *   ... throw TransactionRequiredException..
     *  }
     *
     */
    @Test
    @Transactional
    void auto() {
        final FlushEntity flushEntity = new FlushEntity();
        entityManager.setFlushMode(FlushModeType.AUTO);
        entityManager.persist(flushEntity);
        // Flushing to occur at query execution
        entityManager.createQuery("select f from FlushEntity f", FlushEntity.class).getResultList();
    }

    @Test
//    @Rollback(value = false)  // -> if Rollback is activated, insert query occurs
    @Transactional
    void commit() {
        final FlushEntity flushEntity = new FlushEntity();
        entityManager.setFlushMode(FlushModeType.COMMIT);
        entityManager.persist(flushEntity);
        entityManager.createQuery("select f from FlushEntity f", FlushEntity.class).getResultList();
        // Flushing to occur at transaction commit
    }

    @SpringBootTest
    static class FlushEntitySessionTest {

        @PersistenceContext
        private EntityManager entityManager;

        @Test
        @Rollback(value = false)
        @Transactional
        void manual() {
            final FlushEntity flushEntity = new FlushEntity();
            final Session session = entityManager.unwrap(Session.class);
            session.setFlushMode(FlushMode.MANUAL);
            session.save(flushEntity);
        }
    }

}