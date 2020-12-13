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
}