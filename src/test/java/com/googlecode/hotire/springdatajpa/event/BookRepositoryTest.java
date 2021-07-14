package com.googlecode.hotire.springdatajpa.event;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@Import(EntityListener.class)
@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void find() {
        // given
        final Book book = new Book();
        book.setAge(10);

        // when
         final Book result = repository.saveAndFlush(book.publish());

        entityManager.clear();
        // then
        repository.findById(result.getId())
                  .map(it -> {
                      System.out.println(it);
                      return it;
                  })
                  .orElseThrow();
        entityManager.clear();
        repository.findByAge(result.getAge())
                  .forEach(System.out::println);
    }
}