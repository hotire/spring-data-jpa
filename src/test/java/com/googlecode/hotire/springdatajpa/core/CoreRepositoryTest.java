package com.googlecode.hotire.springdatajpa.core;

import java.util.Optional;
import javax.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@Slf4j
@DataJpaTest
class CoreRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CoreRepository coreRepository;

    @Test
    void saveByEm() {
        entityManager.persist(new Core().setName("hello"));
        entityManager.flush();
        entityManager.clear();

        final Core result = entityManager.find(Core.class, 1L);

        log.info("{}", result);
    }

    @Test
    void save() {
        final Core core = coreRepository.saveAndFlush(new Core().setName("hotire1"));
        entityManager.clear();

        final Core result  = coreRepository.findById(core.getId()).orElseThrow();

        log.info("{}", result);
    }

    @Test
    void nativeFindById() {
        final Optional<Core> result = coreRepository.nativeFindById(1L);
        System.out.println(result.orElse(null));
    }
}