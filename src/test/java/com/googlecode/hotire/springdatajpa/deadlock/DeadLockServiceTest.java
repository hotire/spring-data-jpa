package com.googlecode.hotire.springdatajpa.deadlock;

import javax.annotation.PostConstruct;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;

import com.googlecode.hotire.springdatajpa.utils.ThreadUtils;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@DataJpaTest
@Import(DeadLockService.class)
class DeadLockServiceTest {

    @Autowired
    private DeadLockService deadLockService;

    private DeadLock deadLock;


    @PostConstruct
    public void init() {
        deadLock = deadLockService.saveAndFlush(new DeadLock());
        deadLockService.saveAndFlush(new DeadLock());
        deadLockService.saveAndFlush(new DeadLock());
    }


    @Rollback(value = false)
    @Test
    void save() {
        log.info("deadLock1 : {}", deadLock);
        Mono.create(sink -> { sink.success(deadLockService.readRepeatable(deadLock)); })
            .subscribeOn(Schedulers.elastic())
            .log()
            .subscribe(System.out::println);

        deadLock.setName("hello");

        Mono.create(sink -> { sink.success(deadLockService.saveAndFlush(deadLock)); })
            .subscribeOn(Schedulers.elastic())
            .log()
            .subscribe(System.out::println);

        ThreadUtils.sleep(5000L);
    }

    @Test
    void pessimisticLockingFailureException() {
        Mono.create(sink -> { sink.success(deadLockService.updateAll("1")); })
            .subscribeOn(Schedulers.elastic())
            .log()
            .subscribe(System.out::println);

        ThreadUtils.sleep(1000L);
        deadLock.setName("hello");

        Mono.create(sink -> { sink.success(deadLockService.saveAndFlush(deadLock)); })
            .subscribeOn(Schedulers.elastic())
            .log()
            .subscribe(System.out::println);

        ThreadUtils.sleep(4000L);
    }
}