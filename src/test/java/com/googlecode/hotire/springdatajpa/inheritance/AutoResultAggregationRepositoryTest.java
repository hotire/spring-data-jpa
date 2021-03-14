package com.googlecode.hotire.springdatajpa.inheritance;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.googlecode.hotire.springdatajpa.inheritance.result.AutoResult;

@DataJpaTest
class AutoResultAggregationRepositoryTest {

    @Autowired
    private AutoResultAggregationRepository autoResultAggregationRepository;

    @Test
    void save() {
        final AutoResultAggregation aggregation = new AutoResultAggregation();
        final AutoResult autoResult = new AutoResult();
        autoResult.setAuto("auto");
        autoResultAggregationRepository.saveAndFlush(aggregation);
    }
}