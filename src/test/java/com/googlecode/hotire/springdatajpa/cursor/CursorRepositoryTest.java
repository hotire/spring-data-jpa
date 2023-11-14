package com.googlecode.hotire.springdatajpa.cursor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class CursorRepositoryTest {

    @Autowired
    private CursorRepository cursorRepository;

    @Test
    @Transactional
    void stream() {
        cursorRepository.streamAllBy();
    }
}