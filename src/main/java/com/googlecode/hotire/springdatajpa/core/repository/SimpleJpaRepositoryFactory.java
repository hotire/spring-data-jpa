package com.googlecode.hotire.springdatajpa.core.repository;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryComposition;
import org.springframework.data.util.ReflectionUtils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @see org.springframework.data.jpa.repository.support.SimpleJpaRepository
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SimpleJpaRepositoryFactory {

    /**
     * @see org.springframework.data.repository.core.support.RepositoryFactorySupport#getTargetRepositoryViaReflection(Class, Object...)
     */
    @SuppressWarnings("unchecked")
    public static <R> R getTargetRepositoryViaReflection(final Class<?> baseClass, final Object... constructorArguments) {
        final Optional<Constructor<?>> constructor = ReflectionUtils.findConstructor(baseClass, constructorArguments);

        return constructor.map(it -> (R) BeanUtils.instantiateClass(it, constructorArguments))
                          .orElseThrow(() -> new IllegalStateException(String.format(
                                  "No suitable constructor found on %s to match the given arguments: %s. Make sure you implement a constructor taking these",
                                  baseClass, Arrays.stream(constructorArguments).map(Object::getClass).collect(Collectors.toList()))));
    }

    /**
     * @see org.springframework.data.repository.core.support.RepositoryFactorySupport#getRepositoryInformation(RepositoryMetadata, RepositoryComposition)
     */
    private RepositoryInformation getRepositoryInformation(final RepositoryMetadata metadata,
                                                           final RepositoryComposition composition) {
        getRepositoryBaseClass(metadata);
        return null;
    }

    /**
     * @see org.springframework.data.repository.core.support.RepositoryFactorySupport#getRepositoryBaseClass(RepositoryMetadata)
     * @see org.springframework.data.jpa.repository.support.JpaRepositoryFactory#getRepositoryBaseClass(RepositoryMetadata)
     */
    protected Class<?> getRepositoryBaseClass(final RepositoryMetadata metadata) {
        return null;
    }
}
