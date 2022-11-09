package com.googlecode.hotire.springdatajpa.core.access;

import javax.persistence.AccessType;
import org.hibernate.property.access.internal.PropertyAccessMixedImpl;

/**
 * @see PropertyAccessMixedImpl
 */
public class PropertyAccessMixedImplCore {

    /**
     * @see PropertyAccessMixedImpl#getAccessType(Class, String) 
     */
    protected static AccessType getAccessType(Class<?> containerJavaType, String propertyName) {
        return AccessType.PROPERTY;
    }
}
