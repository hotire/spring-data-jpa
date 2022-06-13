package com.googlecode.hotire.springdatajpa.event.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;

/**
 * @see org.springframework.data.repository.core.support.EventPublishingRepositoryProxyPostProcessor
 * @see org.springframework.data.repository.core.support.RepositoryProxyPostProcessor
 * @see org.springframework.data.repository.core.support.RepositoryFactorySupport
 * @see org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport
 *
 * RepositoryFactoryBeanSupport 에서 EventPublishingRepositoryProxyPostProcessor 주입
 * RepositoryFactorySupport에서 Repository 생성
 */
public class AbstractAggregateRootCore extends AbstractAggregateRoot<AbstractAggregateRootCore> {
    private transient final @Transient
    List<Object> domainEvents = new ArrayList<>();

    @Override
    @AfterDomainEventPublication
    protected void clearDomainEvents() {
        domainEvents.clear();
    }


    @Override
    @DomainEvents
    protected Collection<Object> domainEvents() {
        return Collections.unmodifiableList(domainEvents);
    }
}
