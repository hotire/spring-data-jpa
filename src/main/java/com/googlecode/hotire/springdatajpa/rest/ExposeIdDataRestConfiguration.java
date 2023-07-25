package com.googlecode.hotire.springdatajpa.rest;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.metamodel.Metamodel;
import javax.persistence.metamodel.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
@RequiredArgsConstructor
public class ExposeIdDataRestConfiguration implements RepositoryRestConfigurer {

    private final EntityManagerFactory entityManagerFactory;

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        getAllManagedEntityTypes(entityManagerFactory).forEach(config::exposeIdsFor);
    }

    private List<Class<?>> getAllManagedEntityTypes(EntityManagerFactory entityManagerFactory) {
        Metamodel metamodel = entityManagerFactory.getMetamodel();
        return metamodel.getManagedTypes()
            .stream()
            .map(Type::getJavaType)
            .filter(javaType -> javaType.isAnnotationPresent(Entity.class))
            .collect(Collectors.toList());
    }

}
