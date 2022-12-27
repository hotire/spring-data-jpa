package com.googlecode.hotire.springdatajpa.core.immutable;

import com.googlecode.hotire.springdatajpa.utils.ThreadUtils;
import javax.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class ImmutableEntityRepositoryTest {

    @Autowired
    private ImmutableEntityRepository repository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void update()  {
        ThreadUtils.newThreadSubmit(() -> {
            log.info("save");
            return repository.saveAndFlush(new ImmutableEntity().setName("hello"));
        });
        ThreadUtils.sleep(1000L);
        log.info("update");
        entityManager.clear();
        repository.findAll().forEach(e -> repository.saveAndFlush(e.setName("hotire")));
    }

}