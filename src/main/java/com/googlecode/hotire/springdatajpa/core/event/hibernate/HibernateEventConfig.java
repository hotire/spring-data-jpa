package com.googlecode.hotire.springdatajpa.core.event.hibernate;

import javax.annotation.PostConstruct;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateEventConfig {

    @Autowired(required = false)
    private SessionFactoryImpl sessionFactory;

    @PostConstruct
    public void init() {
        if (sessionFactory == null)  {
            return;
        }
        final EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);
        registry.getEventListenerGroup(EventType.POST_COMMIT_UPDATE).appendListeners();
    }

}
