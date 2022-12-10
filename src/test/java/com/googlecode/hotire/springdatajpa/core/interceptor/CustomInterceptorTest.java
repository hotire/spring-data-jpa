package com.googlecode.hotire.springdatajpa.core.interceptor;

import static org.junit.jupiter.api.Assertions.*;

import com.googlecode.hotire.springdatajpa.core.Core;
import com.googlecode.hotire.springdatajpa.core.CoreRepository;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomInterceptorTest {

    @Autowired
    private CoreRepository coreRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void save() {
        final Core core = coreRepository.save(new Core());
//        entityManager.flush();


        coreRepository.save(core.setAge(10));

    }
}