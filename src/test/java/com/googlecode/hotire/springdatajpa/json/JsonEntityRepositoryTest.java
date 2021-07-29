package com.googlecode.hotire.springdatajpa.json;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("beta")
@SpringBootTest
class JsonEntityRepositoryTest {

    @Autowired
    private JsonEntityRepository jsonEntityRepository;

    @Test
    @Rollback(value = false)
    void save() {
        final JsonEntity jsonEntity = new JsonEntity();
        final JsonEntity jsonEntity2 = new JsonEntity();
        jsonEntity.setJson(List.of(new Json().setAge(1).setName("hotire"), new Json().setName("hello").setAge(2)));
        jsonEntity2.setJson(List.of(new Json().setAge(4).setName("hotire4"), new Json().setName("hello3").setAge(3)));

        jsonEntityRepository.saveAndFlush(jsonEntity);
        jsonEntityRepository.saveAndFlush(jsonEntity2);
    }

    @Test
    void find() {
        // when
        final List<JsonEntity> result = jsonEntityRepository.findByAge(1);

        System.out.println(result);
    }

}