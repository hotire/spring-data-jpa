package com.googlecode.hotire.springdatajpa.core.repository;

import java.lang.reflect.Method;
import java.util.Set;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.core.CrudMethods;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.util.Streamable;
import org.springframework.data.util.TypeInformation;

/**
 * @see RepositoryInformation
 * @see org.springframework.data.repository.core.support.DefaultRepositoryInformation
 */
@RequiredArgsConstructor
public class RepositoryInformationDecorator implements RepositoryInformation {

    @Getter
    private final RepositoryInformation delegate;

    @Override
    public Class<?> getRepositoryBaseClass() {
        return getDelegate().getRepositoryBaseClass();
    }

    @Override
    public boolean hasCustomMethod() {
        return getDelegate().hasCustomMethod();
    }

    @Override
    public boolean isCustomMethod(final Method method) {
        return getDelegate().isCustomMethod(method);
    }

    @Override
    public boolean isQueryMethod(final Method method) {
        return getDelegate().isQueryMethod(method);
    }

    @Override
    public boolean isBaseClassMethod(final Method method) {
        return getDelegate().isBaseClassMethod(method);
    }

    @Override
    public Streamable<Method> getQueryMethods() {
        return getDelegate().getQueryMethods();
    }

    @Override
    public Method getTargetClassMethod(final Method method) {
        return getDelegate().getTargetClassMethod(method);
    }

    @Override
    public Class<?> getIdType() {
        return getDelegate().getIdType();
    }

    @Override
    public Class<?> getDomainType() {
        return getDelegate().getDomainType();
    }

    @Override
    public Class<?> getRepositoryInterface() {
        return getDelegate().getRepositoryInterface();
    }

    @Override
    public TypeInformation<?> getReturnType(Method method) {
        return getDelegate().getReturnType(method);
    }

    @Override
    public Class<?> getReturnedDomainClass(final Method method) {
        return getDelegate().getReturnedDomainClass(method);
    }

    @Override
    public CrudMethods getCrudMethods() {
        return getDelegate().getCrudMethods();
    }

    @Override
    public boolean isPagingRepository() {
        return getDelegate().isPagingRepository();
    }

    @Override
    public Set<Class<?>> getAlternativeDomainTypes() {
        return getDelegate().getAlternativeDomainTypes();
    }

    @Override
    public boolean isReactiveRepository() {
        return getDelegate().isReactiveRepository();
    }
}
