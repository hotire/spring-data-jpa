package com.googlecode.hotire.springdatajpa.core.repository;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

import com.googlecode.hotire.springdatajpa.core.CoreRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class RepositoryConfig {
    private final CoreRepository coreRepository;

    @PostConstruct
    public void init() {
        log.info("coreRepository");
    }

}
