package com.googlecode.hotire.springdatajpa.core;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.transaction.TransactionManager;

@Slf4j
@DataJpaTest
class CoreRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CoreRepository coreRepository;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private TransactionManager transactionManager;

    @Test
    void saveByEm() {
        entityManager.persist(new Core().setName("hello"));
        entityManager.flush();
        entityManager.clear();

        final Core result = entityManager.find(Core.class, 1L);

        log.info("{}", result);
    }

    @Test
    void save() {
        final Core core = coreRepository.saveAndFlush(new Core().setName("hotire1"));
        entityManager.clear();

        final Core result  = coreRepository.findById(core.getId()).orElseThrow();

        log.info("{}", result);
    }

    @Test
    void nativeFindById() {
        final Optional<Core> result = coreRepository.nativeFindById(1L);
        log.info("{}", result);
    }

    @Test
    void findByName() {
        final Optional<Core> result = coreRepository.findByName("");
        log.info("{}", result);
    }

    @Test
    void page() {
        coreRepository.saveAll(IntStream.range(0, 1000)
            .mapToObj(it -> new Core().setName(String.valueOf(it))).collect(Collectors.toList())
        );
        coreRepository.flush();

        int count = 1;
        Page<Core> result = coreRepository.findAll(PageRequest.of(0, 10, Sort.by(Direction.DESC, "name")));
        System.out.println(result);
        while (!result.isLast()) {
            count++;
            final Pageable next = result.nextPageable();
            result = coreRepository.findAll(next);
            System.out.println(result.stream().map(Core::getName).collect(Collectors.joining()));
        }

        System.out.println(count);
    }

    @Test
    void update() {
        final Core core = new Core().setName("hello").setAge(10);
        coreRepository.saveAndFlush(core);
        entityManager.clear();

        coreRepository.saveAndFlush(core.setAge(20));
    }

    @Test
    void QBE() {
        // given
        final Core core = new Core()
            .setAge(10)
            .setName("hello");

        entityManager.persist(core);
        entityManager.flush();
        entityManager.clear();

        // when
        final Optional<Core> result = coreRepository.findOne(Example.of(core));

        // no assert
        log.info("{}", result.orElse(null));
    }
}