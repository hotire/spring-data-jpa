package com.googlecode.hotire.springdatajpa.deadlock.index;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@Import(DeadLockIndexService.class)
@DataJpaTest
class DeadLockIndexRepositoryTest {

    @Autowired
    private DeadLockIndexRepository deadLockIndexRepository;

    @Autowired
    private DeadLockIndexService deadLockIndexService;

    @Autowired
    private EntityManager entityManager;

    @Test
    void deadlock() {
        // given
        final Long id = 1L;
        final CompletableFuture<DeadLockIndex> future = Mono
                .<DeadLockIndex>fromRunnable(() -> deadLockIndexService.saveAndRollback(new DeadLockIndex(id)))
                .subscribeOn(Schedulers.elastic())
                .log()
                .toFuture();
        final Queue<Throwable> erros = new ConcurrentLinkedQueue<>();
        final Queue<DeadLockIndex> success = new ConcurrentLinkedQueue<>();

        // when
        Mono.<DeadLockIndex>fromRunnable(() -> deadLockIndexRepository.save(new DeadLockIndex(id)))
            .subscribeOn(Schedulers.elastic())
            .doOnError(error -> {
                log.error("doOnError1 : {}", error.getMessage());
                erros.add(error);
            })
            .doOnSuccess(it -> {
                log.info("doOnSuccess1 : {}",  it);
                success.add(it);
            })
            .log()
            .subscribe();
        Mono.<DeadLockIndex>fromRunnable(() -> deadLockIndexRepository.save(new DeadLockIndex(id)))
            .subscribeOn(Schedulers.elastic())
            .doOnError(error -> {
                log.error("doOnError2 : {}", error.getMessage());
                erros.add(error);
            })
            .doOnSuccess(it -> {
                log.info("doOnSuccess2 : {}",  it);
                success.add(it);
            })
            .log()
            .subscribe();
        final DeadLockIndex result = future.join();

        // then
        assertThat(entityManager.contains(result)).isFalse();
        assertThat(erros.size()).isEqualTo(1);
        assertThat(success.poll()).isNull();;
    }

}