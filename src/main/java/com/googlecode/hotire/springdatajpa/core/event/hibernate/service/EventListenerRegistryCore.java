package com.googlecode.hotire.springdatajpa.core.event.hibernate.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.event.service.internal.EventListenerRegistryImpl;
import org.hibernate.event.service.spi.EventListenerGroup;
import org.hibernate.event.service.spi.EventListenerRegistry;

/**
 * @see EventListenerRegistry
 * @see EventListenerRegistryImpl
 */
@RequiredArgsConstructor
public class EventListenerRegistryCore {

    /**
     * @see EventListenerRegistryImpl#registeredEventListeners
     */
    private final EventListenerGroup[] registeredEventListeners;
}
