package com.googlecode.hotire.springdatajpa.lock;

import java.util.concurrent.Callable;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.hotire.springdatajpa.lock.LockEntityRepositoryTest.TransactionService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@DataJpaTest
@Import(TransactionService.class)
class LockEntityRepositoryTest {

    @Autowired
    private LockEntityRepository repository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private TransactionService transactionService;

    @Test
    void findByIdForUpdate() throws Exception {
        final LockEntity result = transactionService.requiresNew(() -> repository.saveAndFlush(new LockEntity()));
        entityManager.clear();
        final LockEntity l = repository.findByIdForUpdate(result.getId()).get();
        Mono.fromRunnable(() -> transactionService.run(() ->  {
            final LockEntity inner = entityManager.find(LockEntity.class, result.getId(), LockModeType.PESSIMISTIC_WRITE);
            try {
                log.info("entity : {}", inner.getId());
                Thread.sleep(4000L);
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        })).subscribeOn(Schedulers.elastic())
            .subscribe();

        log.info("entity : {}", l.getId());
        Thread.sleep(4000L);
    }

    @Service
    public static class TransactionService {

        @Transactional(propagation = Propagation.REQUIRES_NEW)
        public <T> T requiresNew(final Callable<T> callable) throws Exception {
            return callable.call();
        }

        @Transactional
        public void run(final Runnable runnable) {
            runnable.run();
        }
    }
}