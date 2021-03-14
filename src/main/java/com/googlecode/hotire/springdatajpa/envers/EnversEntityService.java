package com.googlecode.hotire.springdatajpa.envers;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class EnversEntityService {
    private final EnversEntityRepository enversEntityRepository;

    @PostConstruct
    public void init() {
        enversEntityRepository.save(new EnversEntity());
    }

}
