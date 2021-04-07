package com.googlecode.hotire.springdatajpa.open;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class OpenEntityManagerServiceTest {

    @Autowired
    private OpenEntityManagerService openEntityManagerService;

    @Test
    void select() {
        openEntityManagerService.select();
        log.info("clear");
        log.info("clear");
        openEntityManagerService.selectWithOpenEntityManager();
    }
}