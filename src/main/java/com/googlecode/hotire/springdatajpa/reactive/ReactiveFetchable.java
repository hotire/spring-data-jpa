package com.googlecode.hotire.springdatajpa.reactive;

import java.util.List;

import com.mysema.commons.lang.CloseableIterator;
import com.querydsl.core.NonUniqueResultException;
import com.querydsl.core.QueryResults;

import reactor.core.publisher.Mono;

public interface ReactiveFetchable<T> {
    Mono<List<T>> fetchRx();

    Mono<T> fetchFirstRx();

    Mono<T> fetchOneRx() throws NonUniqueResultException;

    Mono<CloseableIterator<T>> iterateRx();

    Mono<QueryResults<T>> fetchResultsRx();

    Mono<Long> fetchCountRx();
}
