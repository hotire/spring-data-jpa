package com.googlecode.hotire.springdatajpa.core.entity;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@DataJpaTest
class EntityCoreRepositoryTest {

    @Autowired
    private EntityCoreRepository repository;

    @Autowired
    private EntityManager entityManager;


    @Test
    void save() {
        final EntityCore core = repository.saveAndFlush(new EntityCore());
        repository.findById(core.getId()).ifPresent(it -> log.info("EntityCore : {}", it.getId()));
        repository.saveAndFlush(core);
        entityManager.clear();;
        repository.findById(core.getId()).ifPresent(it -> log.info("EntityCore : {}", it.getId()));
        repository.saveAndFlush(core);
    }


}