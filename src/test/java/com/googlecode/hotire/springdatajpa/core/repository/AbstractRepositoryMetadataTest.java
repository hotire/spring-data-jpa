package com.googlecode.hotire.springdatajpa.core.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.AbstractRepositoryMetadata;

import lombok.Data;

/**
 * @see org.springframework.data.repository.core.support.AbstractRepositoryMetadata
 */
class AbstractRepositoryMetadataTest {

    @Data
    static class Entity {
        private Long id;
    }

    interface CustomRepository extends Repository<Entity, Long> {

    }

    @Test
    void getMetadata() {
        // when
        final RepositoryMetadata repositoryMetadata = AbstractRepositoryMetadata.getMetadata(CustomRepository.class);

        // then
        assertThat(repositoryMetadata).isNotNull();
    }
}