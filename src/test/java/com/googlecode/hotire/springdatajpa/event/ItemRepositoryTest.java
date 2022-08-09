package com.googlecode.hotire.springdatajpa.event;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;

@Import(EntityListener.class)
@DataJpaTest
class ItemRepositoryTest {

    @Autowired
    private ItemRepository repository;

    @Rollback(value = false)
    @Test
    void publish() {
        // given
        final Item item = new Shield();

        // when
        repository.saveAndFlush(item.publish());

        // no assert
    }

    @Test
    void publish_callback() {
        // given
        final Item item = new Shield();

        // when then
        repository.save(item.publish());
    }

}