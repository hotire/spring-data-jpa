package com.googlecode.hotire.springdatajpa.core;

import java.util.Optional;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CoreService {
    private final CoreRepository coreRepository;

    @PostConstruct
    public void init() {
        coreRepository.save(new Core().setName("n1"));
        coreRepository.save(new Core().setName("n2"));
        coreRepository.save(new Core().setName("n3"));
    }

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

    @Transactional(readOnly = true)
    public Optional<Core> findByName(String name) {
        return coreRepository.findByName(name);
    }
}
