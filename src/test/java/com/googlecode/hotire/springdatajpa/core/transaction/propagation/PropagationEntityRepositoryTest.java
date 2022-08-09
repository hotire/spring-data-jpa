package com.googlecode.hotire.springdatajpa.core.transaction.propagation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
class PropagationEntityRepositoryTest {

    @Autowired
    private PropagationEntityRepository repository;

    @Test
    @Transactional
    void saveWithNested() {
        repository.saveAndFlush(new PropagationEntity());
        repository.saveWithNested(new PropagationEntity());
    }
}