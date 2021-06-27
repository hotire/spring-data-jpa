package com.googlecode.hotire.springdatajpa.deadlock;

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

    public DeadLock saveAndFlush(final DeadLock deadLock) {
        return repository.saveAndFlush(deadLock);
    }
}
