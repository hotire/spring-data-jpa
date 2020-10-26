package com.googlecode.hotire.springdatajpa.query.type;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@DisplayName("development")
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
}