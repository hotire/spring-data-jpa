package com.googlecode.hotire.springdatajpa.reactive;

import java.util.List;

import com.mysema.commons.lang.CloseableIterator;
import com.querydsl.core.NonUniqueResultException;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQuery;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class ReactiveJPAQuery<T> extends JPAQuery<T> implements ReactiveFetchable<T> {

    private final Scheduler scheduler;

    public ReactiveJPAQuery() {
        this.scheduler = Schedulers.boundedElastic();
    }
    public ReactiveJPAQuery(final Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public Mono<List<T>> fetchRx() {
        return Mono.<List<T>>create(sink -> sink.success(fetch()))
                .subscribeOn(scheduler);
    }

    @Override
    public Mono<T> fetchFirstRx() {
        return Mono.<T>create(sink -> sink.success(fetchFirst()))
                .subscribeOn(scheduler);
    }

    @Override
    public Mono<T> fetchOneRx() throws NonUniqueResultException {
        return Mono.<T>create(sink -> sink.success(fetchOne()))
                .subscribeOn(scheduler);
    }

    @Override
    public Mono<CloseableIterator<T>> iterateRx() {
        return Mono.<CloseableIterator<T>>create(sink -> sink.success(iterate()))
                .subscribeOn(scheduler);
    }

    @Override
    public Mono<QueryResults<T>> fetchResultsRx() {
        return Mono.<QueryResults<T>>create(sink -> sink.success(fetchResults()))
                .subscribeOn(scheduler);
    }

    @Override
    public Mono<Long> fetchCountRx() {
        return Mono.<Long>create(sink -> sink.success(fetchCount()))
                .subscribeOn(scheduler);
    }
}
