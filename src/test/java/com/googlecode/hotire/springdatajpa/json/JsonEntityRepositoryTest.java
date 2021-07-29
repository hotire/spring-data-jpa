package com.googlecode.hotire.springdatajpa.json;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("beta")
@SpringBootTest
class JsonEntityRepositoryTest {

    @Autowired
    private JsonEntityRepository jsonEntityRepository;


    @Test
    void find() {
        // when
        final List<JsonEntity> result = jsonEntityRepository.findByAge(1);

        // then
        assertThat(result).isNotNull();
    }

}