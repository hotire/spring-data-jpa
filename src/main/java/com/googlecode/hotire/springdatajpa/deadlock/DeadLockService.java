package com.googlecode.hotire.springdatajpa.deadlock;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.hotire.springdatajpa.utils.ThreadUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeadLockService {
    private final DeadLockRepository repository;

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public DeadLock save(final DeadLock deadLock) {
        return Optional.ofNullable(deadLock.getId())
                       .flatMap(repository::findById)
                       .map(it -> {
                           ThreadUtils.sleep(4000L);
                           return it;
                       })
                       .map(repository::save)
                       .orElseGet(() -> repository.save(deadLock));
    }
}
