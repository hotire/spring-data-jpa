package com.googlecode.hotire.springdatajpa.core.action;

import java.io.Serializable;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

/**
 * @see org.hibernate.persister.entity.EntityPersister
 */
public class EntityPersisterCore {

    /**
     * @see org.hibernate.persister.entity.EntityPersister#insert(Object[], Object, SharedSessionContractImplementor)
     */
    public void insert(Serializable id, Object[] fields, Object object, SharedSessionContractImplementor session) {
        
    }
}
