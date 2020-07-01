package com.googlecode.hotire.springdatajpa.event;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

//@Import(EntityListener.class)
@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    void find() {
        // given
        final Book book = new Book();

        // when
        repository.save(book.publish());

        // then
    }
}