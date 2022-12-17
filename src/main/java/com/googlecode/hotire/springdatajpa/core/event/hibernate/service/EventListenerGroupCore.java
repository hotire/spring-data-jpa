package com.googlecode.hotire.springdatajpa.core.event.hibernate.service;

import org.hibernate.event.service.spi.EventListenerGroup;

/**
 * @see EventListenerGroup
 * @see org.hibernate.event.service.internal.EventListenerGroupImpl
 * @see org.hibernate.event.service.internal.PostCommitEventListenerGroupImpl
 */
public class EventListenerGroupCore<T> {


    /**
     * @see EventListenerGroup#appendListener(Object)
     */
    public void appendListener(T listener) {
    }
}
