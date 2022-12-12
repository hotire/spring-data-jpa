package com.googlecode.hotire.springdatajpa.core.event.hibernate;

import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class HibernateEventConfig {

    private final SessionFactoryImpl sessionFactory;

    @PostConstruct
    public void init() {
        final EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);
        registry.getEventListenerGroup(EventType.POST_COMMIT_UPDATE).appendListeners();
    }

}
