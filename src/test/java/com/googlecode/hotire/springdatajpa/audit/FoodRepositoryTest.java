package com.googlecode.hotire.springdatajpa.audit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.TestConstructor.AutowireMode;

import lombok.RequiredArgsConstructor;

@DisplayName("development")
@DataJpaTest
@RequiredArgsConstructor
@TestConstructor(autowireMode = AutowireMode.ALL)
class FoodRepositoryTest {

    private final FoodRepository foodRepository;

    @Test
    void audit() {
        // when
        final Food food = foodRepository.saveAndFlush(new Food().setName("pasta"));

        // then
        assertThat(food.getCreatedDate()).isNotNull();
        assertThat(food.getModifiedDate()).isNotNull();
    }
}