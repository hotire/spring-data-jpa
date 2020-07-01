package com.googlecode.hotire.springdatajpa.event;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@Import(EntityListener.class)
@DataJpaTest
class ItemRepositoryTest {

    @Autowired
    private ItemRepository repository;

    @Test
    void find() {
        // given
        final Item item = new Shield();

        // when
        repository.save(item.publish());

        // then
    }

}