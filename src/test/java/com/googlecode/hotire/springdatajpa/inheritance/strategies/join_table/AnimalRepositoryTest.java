package com.googlecode.hotire.springdatajpa.inheritance.strategies.join_table;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@DataJpaTest
class AnimalRepositoryTest {

    @Autowired
    private AnimalRepository repository;

    @Autowired
    private DogRepository dogRepository;

    @TestFactory
    Stream<DynamicTest> save() {
        return List.of(new Animal(), new Dog(), new Cat())
                   .stream()
                   .map(it -> DynamicTest.dynamicTest("save, param : " + it, () -> {
                       final var result = repository.saveAndFlush(it);
                       log.info("result : {}", result);
                   }));
    }

    @Test
    void findAll() {
        repository.saveAll(List.of(new Animal(), new Dog(), new Cat()));
        repository.flush();
        repository.findAll().forEach(it -> log.info("result {}", it));
    }

    @Test
    void saveDog() {
        final var result = dogRepository.saveAndFlush(new Dog());
        log.info("result : {}", result);
    }
}