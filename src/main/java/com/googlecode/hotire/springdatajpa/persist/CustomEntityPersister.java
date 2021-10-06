package com.googlecode.hotire.springdatajpa.persist;

import java.io.Serializable;

import org.hibernate.LockMode;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.persister.entity.EntityPersister;

/**
 * @see EntityPersister
 * @see org.hibernate.persister.entity.AbstractEntityPersister#load(Serializable, Object, LockMode, SharedSessionContractImplementor)
 *  -> getLoader()
 * @see org.hibernate.loader.entity.AbstractEntityLoader
 * @see org.hibernate.loader.Loader
 */
public class CustomEntityPersister {
}
