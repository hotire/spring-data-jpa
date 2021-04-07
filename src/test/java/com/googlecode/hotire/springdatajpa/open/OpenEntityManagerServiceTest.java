package com.googlecode.hotire.springdatajpa.open;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OpenEntityManagerServiceTest {

    @Autowired
    private OpenEntityManagerService openEntityManagerService;

    @Test
    void select() {
        openEntityManagerService.select();
        System.out.println("clear");
        System.out.println("clear");
        openEntityManagerService.selectWithOpenEntityManager();
    }
}