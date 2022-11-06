package com.googlecode.hotire.springdatajpa.core.repository.method;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.JpaQueryMethod;
/**
 * @see org.springframework.data.repository.query.QueryMethod
 * @see org.springframework.data.jpa.repository.query.JpaQueryMethod
 */
public class QueryMethodCore {

    /**
     * @see JpaQueryMethod#getAnnotationValue(String, Class) 
     */
    private <T> T getAnnotationValue(String attribute, Class<T> type) {
//        return getMergedOrDefaultAnnotationValue(attribute, Query.class, type);
        return null;
    }
}
