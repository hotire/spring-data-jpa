package com.googlecode.hotire.springdatajpa.core.interceptor;

import java.io.Serializable;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

@Slf4j
public class CustomInterceptor extends EmptyInterceptor {

    @Override
    public boolean onFlushDirty(
        Object entity,
        Serializable id,
        Object[] currentState,
        Object[] previousState,
        String[] propertyNames,
        Type[] types) {
        log.info("entity : {}", entity);
        log.info("currentState : {}", currentState);
        log.info("previousState : {}", previousState);
        log.info("propertyNames : {}", propertyNames);
        log.info("types : {}", types);
        return false;
    }

    @Override
    public boolean onSave(
        Object entity,
        Serializable id,
        Object[] state,
        String[] propertyNames,
        Type[] types) {
        log.info("entity : {}", entity);
        log.info("propertyNames : {}", propertyNames);
        log.info("types : {}", types);
        return false;
    }
}
