package com.googlecode.hotire.springdatajpa.exists;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ExistsEntityRepositoryTest {

    @Autowired
    private ExistsEntityRepository existsEntityRepository;

    @Test
    void existsByName() {
        // given
        final ExistsEntity entity = new ExistsEntity();
        entity.setName("hotire");
        existsEntityRepository.saveAndFlush(entity);

        // when
        final Boolean result = existsEntityRepository.existsByName(entity.getName());

        // then
        assertThat(result).isTrue();
    }

    @Test
    void existsByQuery() {
        // given
        final ExistsEntity entity = new ExistsEntity();
        entity.setName("hotire");
        existsEntityRepository.saveAndFlush(entity);

        // when
        final Boolean result = existsEntityRepository.existsByQuery(entity.getName());

        // then
        assertThat(result).isTrue();
    }
}