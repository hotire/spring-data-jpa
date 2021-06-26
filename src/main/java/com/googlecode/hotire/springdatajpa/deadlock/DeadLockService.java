package com.googlecode.hotire.springdatajpa.deadlock;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeadLockService {
    private final DeadLockRepository repository;

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void save(DeadLock deadLock) {
        repository.findById(deadLock.getId())
                  .map(it -> {
                      try {
                          Thread.sleep(4000);
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                      return it;
                  })
                  .map(repository::save)
                  .orElseGet(() -> repository.save(deadLock));
    }
}
