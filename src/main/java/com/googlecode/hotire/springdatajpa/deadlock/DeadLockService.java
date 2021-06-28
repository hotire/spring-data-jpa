package com.googlecode.hotire.springdatajpa.deadlock;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.hotire.springdatajpa.utils.ThreadUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeadLockService {
    private final DeadLockRepository repository;
    private final EntityManager entityManager;


    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public DeadLock readRepeatable(final DeadLock deadLock) {
        return Optional.ofNullable(deadLock.getId())
                       .flatMap(repository::findById)
                       .flatMap(it -> {
                           log.info("sleep");
                           entityManager.clear();
                           ThreadUtils.sleep(4000L);
                           return repository.findById(deadLock.getId());
                       })
                       .orElse(null);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public List<DeadLock> updateAll(String name) {
        final List<DeadLock> result = repository.findAll();
        result.forEach(it -> { repository.saveAndFlush(it.setName(name)); });
        result.forEach(it -> log.info("{}", it));
        result.forEach(it -> log.info("{}", it.getResult()));
        log.info("sleep");
        ThreadUtils.sleep(1000L);
        repository.findAll().forEach(it -> log.info("{}", it));
        ThreadUtils.sleep(3000L);
        return result;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ,timeout = 1000)
    public DeadLock saveAndFlush(final DeadLock deadLock) {
        return repository.saveAndFlush(deadLock);
    }
}
