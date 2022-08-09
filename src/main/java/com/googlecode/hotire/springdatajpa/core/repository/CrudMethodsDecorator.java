package com.googlecode.hotire.springdatajpa.core.repository;

import java.lang.reflect.Method;
import java.util.Optional;

import org.springframework.data.repository.core.CrudMethods;
import org.springframework.data.repository.core.support.DefaultCrudMethods;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @see org.springframework.data.repository.core.CrudMethods;
 * @see org.springframework.data.repository.core.support.DefaultCrudMethods;
 */
@RequiredArgsConstructor
public class CrudMethodsDecorator implements CrudMethods {

    @Getter
    private final DefaultCrudMethods delegate;

    @Override
    public Optional<Method> getSaveMethod() {
        return getDelegate().getSaveMethod();
    }

    @Override
    public boolean hasSaveMethod() {
        return getDelegate().hasSaveMethod();
    }

    @Override
    public Optional<Method> getFindAllMethod() {
        return getDelegate().getFindAllMethod();
    }

    @Override
    public boolean hasFindAllMethod() {
        return getDelegate().hasFindAllMethod();
    }

    @Override
    public Optional<Method> getFindOneMethod() {
        return getDelegate().getFindOneMethod();
    }

    @Override
    public boolean hasFindOneMethod() {
        return getDelegate().hasFindOneMethod();
    }

    @Override
    public Optional<Method> getDeleteMethod() {
        return getDelegate().getDeleteMethod();
    }

    @Override
    public boolean hasDelete() {
        return getDelegate().hasDelete();
    }
}
