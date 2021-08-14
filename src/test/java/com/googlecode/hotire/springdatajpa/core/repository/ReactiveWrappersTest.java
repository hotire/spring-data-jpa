package com.googlecode.hotire.springdatajpa.core.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.data.repository.util.ReactiveWrappers;

import reactor.core.publisher.Mono;

class ReactiveWrappersTest {


    interface ReactiveRepository {
        Mono<String> findById(String id);
        String findById(Mono<String> id);
    }

    interface Repository {
        String findById(String id);
    }

    @Test
    void usesReactiveType() {
        // when
        final boolean result = ReactiveWrappers.usesReactiveType(ReactiveRepository.class);
        final boolean result2 = ReactiveWrappers.usesReactiveType(Repository.class);

        // then
        assertThat(result).isTrue();
        assertThat(result2).isFalse();
    }
}
