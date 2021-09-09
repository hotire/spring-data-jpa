package com.googlecode.hotire.springdatajpa.event_listener;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.TestConstructor.AutowireMode;

import lombok.RequiredArgsConstructor;

@DataJpaTest
@RequiredArgsConstructor
@TestConstructor(autowireMode = AutowireMode.ALL)
class EntityListenersEntityRepositoryTest {

    private final EntityListenersEntityRepository repository;

    // BeansException
    @Test
    void save() {
        repository.save(new EntityListenersEntity());
    }

}