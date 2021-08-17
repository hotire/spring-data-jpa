package com.googlecode.hotire.springdatajpa.core.entity_manager;

import javax.persistence.EntityManager;

import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;

/***
 * @see org.hibernate.internal.AbstractSessionImpl
 * @see org.hibernate.internal.SessionImpl
 */
@RequiredArgsConstructor
public class CustomEntityManager implements EntityManager {
    @Delegate
    private final EntityManager delegate;
}
