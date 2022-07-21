package com.googlecode.hotire.springdatajpa.core.persistence_context;

import org.hibernate.engine.spi.EntityKey;

/**
 * @see org.hibernate.engine.spi.PersistenceContext
 * @see org.hibernate.engine.internal.StatefulPersistenceContext
 */
public class PersistenceContextCore {

    /**
     * @see org.hibernate.engine.spi.PersistenceContext#addEntity(EntityKey, Object)
     * @see org.hibernate.engine.internal.StatefulPersistenceContext#addEntity(EntityKey, Object)
     */
    void addEntity(final EntityKey key, final Object entity) {

    }
}
