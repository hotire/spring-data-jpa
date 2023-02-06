package com.googlecode.hotire.springdatajpa.core;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class CoreServiceTest {

    @Autowired
    private CoreService coreService;

    @Test
    @Transactional(readOnly = true)
    void findByName() {
        coreService.findByName("hello");
    }

}