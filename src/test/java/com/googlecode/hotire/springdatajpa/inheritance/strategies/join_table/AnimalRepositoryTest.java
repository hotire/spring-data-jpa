package com.googlecode.hotire.springdatajpa.inheritance.strategies.join_table;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class AnimalRepositoryTest {

    @Autowired
    private AnimalRepository repository;

    @Test
    void save() {
        final Animal animal = new Animal();
        repository.saveAndFlush(animal);
    }

}