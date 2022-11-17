package com.googlecode.hotire.springdatajpa.core;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CoreService {
    private final CoreRepository coreRepository;

    @Transactional
    public void transactional() throws InterruptedException {
        Thread.sleep(5000L);
        System.out.println("debug");
    }

    @Transactional
    public void listInTransactional() {
        System.out.println("debug");
        coreRepository.findAll();
    }
}
