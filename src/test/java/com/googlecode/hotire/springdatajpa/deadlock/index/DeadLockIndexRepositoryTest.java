package com.googlecode.hotire.springdatajpa.deadlock.index;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import com.googlecode.hotire.springdatajpa.utils.ThreadUtils;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Import(DeadLockIndexService.class)
@DataJpaTest
class DeadLockIndexRepositoryTest {

    @Autowired
    private DeadLockIndexRepository deadLockIndexRepository;

    @Autowired
    private DeadLockIndexService deadLockIndexService;

    @Test
    void deadlock() {
        // given
        final Long id = 1L;

        Mono.fromRunnable(() -> deadLockIndexService.saveAndRollback(new DeadLockIndex(id)))
            .subscribeOn(Schedulers.elastic())
            .subscribe();

        Mono.fromRunnable(() -> deadLockIndexRepository.save(new DeadLockIndex(id)))
            .subscribeOn(Schedulers.elastic())
            .subscribe();
        Mono.fromRunnable(() -> deadLockIndexRepository.save(new DeadLockIndex(id)))
            .subscribeOn(Schedulers.elastic())
            .subscribe();

        ThreadUtils.sleep(4000L);
    }

}