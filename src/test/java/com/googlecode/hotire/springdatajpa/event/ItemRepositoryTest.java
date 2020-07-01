package com.googlecode.hotire.springdatajpa.event;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@Import(EntityListener.class)
@DataJpaTest
class ItemRepositoryTest {

    @Autowired
    private ItemRepository repository;

    @Test
    void publish() {
        // given
        final Item item = new Shield();

        // when
        repository.save(item.publish());

        // no assert
    }

    @Test
    void publish_callback() {
        // given
        final Item item = new Shield();

        // when then
        repository.save(item.publish(it -> assertThat(it).isNotNull()));
    }

}