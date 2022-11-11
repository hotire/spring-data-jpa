package com.googlecode.hotire.springdatajpa.core.access;

import org.hibernate.cfg.AccessType;
import org.hibernate.cfg.InheritanceState;

/**
 * @see InheritanceState
 */
public class InheritanceStateCore {

    /**
     * determineDefaultAccessType Id
     * @see InheritanceState#determineDefaultAccessType()
     */
    private AccessType determineDefaultAccessType() {
        return AccessType.DEFAULT;
    }

}
