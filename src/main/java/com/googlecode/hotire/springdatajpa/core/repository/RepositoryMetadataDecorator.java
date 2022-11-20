package com.googlecode.hotire.springdatajpa.core.repository;

import java.lang.reflect.Method;
import java.util.Set;

import org.springframework.data.repository.core.CrudMethods;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryComposition.RepositoryFragments;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.TypeInformation;

/**
 * @see org.springframework.data.repository.core.support.RepositoryFactorySupport#getRepository(Class, RepositoryFragments) 
 */
@RequiredArgsConstructor
public class RepositoryMetadataDecorator implements RepositoryMetadata {

    @Getter
    private final RepositoryMetadata delegate;

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
