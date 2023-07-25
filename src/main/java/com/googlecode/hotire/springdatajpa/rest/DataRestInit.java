package com.googlecode.hotire.springdatajpa.rest;

import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataRestInit {

    private final DataRestRepository repository;

    @PostConstruct
    void afterPropertiesSet() throws Exception {
        repository.save(new DataRest().setName("hotire"));
    }
}
