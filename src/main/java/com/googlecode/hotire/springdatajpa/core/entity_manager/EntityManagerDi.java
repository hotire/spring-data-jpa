package com.googlecode.hotire.springdatajpa.core.entity_manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequestMapping("/di/entity")
@RestController
@RequiredArgsConstructor
public class EntityManagerDi {
    private final EntityManagerFactory factory;
    private final EntityManager manager;

    // org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean@5851cfe6
    // Shared EntityManager proxy for target factory [org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean@5851cfe6]
    @GetMapping
    void di() {
        System.out.println(factory);
        System.out.println(manager);
    }
}
