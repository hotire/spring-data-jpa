package com.googlecode.hotire.springdatajpa.event_listener;

import javax.persistence.PrePersist;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomEntityListener {

    private EntityListenerService service;

    private EntityListenersEntityRepository repository;

    public CustomEntityListener() {
        log.info("CustomEntityListener");
    }

    @PrePersist
    public void touchForCreate(final Object target) {
        log.info("touchForCreate {}", target);
    }

    @Autowired
    public void setService(final EntityListenerService service) {
        this.service = service;
        log.info("EntityListenerService {}", service);
    }

    @Autowired
    public void setRepository(final EntityListenersEntityRepository repository) {
        this.repository = repository;
        log.info("EntityListenersEntityRepository {}", repository);
    }
}
