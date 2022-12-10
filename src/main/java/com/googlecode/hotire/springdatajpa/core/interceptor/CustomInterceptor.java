package com.googlecode.hotire.springdatajpa.core.interceptor;

import java.io.Serializable;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomInterceptor extends EmptyInterceptor implements HibernatePropertiesCustomizer {

    private final ApplicationContext context;

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

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        hibernateProperties.put("hibernate.session_factory.interceptor", this);
    }
}
