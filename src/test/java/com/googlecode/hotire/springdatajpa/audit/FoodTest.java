package com.googlecode.hotire.springdatajpa.audit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FoodTest {

    @Test
    void isAuditable() {
        // given
        final Food food = new Food();

        // when
        final boolean result = food.isAuditable();

        // then
        assertThat(result).isEqualTo(true);
    }

    @Test
    void getName() {
        // given
        final String name = "hello";
        final Food food = new Food().setName(name);

        // when
        final String result = food.getName();

        // then
        assertThat(result).isEqualTo(name);
    }
}
