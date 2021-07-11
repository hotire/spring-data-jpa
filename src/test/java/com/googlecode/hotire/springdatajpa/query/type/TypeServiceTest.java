package com.googlecode.hotire.springdatajpa.query.type;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class TypeServiceTest {

    @Autowired
    private TypeService typeService;

    @Autowired
    private TypeRepository typeRepository;

    @Test
    void findAll() {
        final List<Type> types = typeRepository.findAll();
        log.info("{}", typeService.findAll(types));
    }

    @Test
    void findByOwnerName() {
        log.info("{}", typeService.findByOwnerName("a"));
    }

    @Test
    void findByOwnerNameWithPrepared() {
        log.info("{}", typeService.findByOwnerNameWithPrepared("a"));
    }

    @Test
    void findByOwnerNameAndIdByCb() {
        log.info("{}", typeService.findByOwnerNameAndIdByCb(1L, "a"));
    }

    @Test
    void findByOwnerNameAndIdByCbWithParam() {
        log.info("{}", typeService.findByOwnerNameAndIdByCbWithParam(1L,"a"));
    }
}