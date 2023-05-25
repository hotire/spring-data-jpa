package com.googlecode.hotire.springdatajpa.rest.core;

import java.util.Optional;
import org.springframework.data.repository.support.Repositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.RepositoryResourceMappings;
import org.springframework.data.rest.webmvc.config.CorsConfigurationAware;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.data.rest.webmvc.support.JpaHelper;

/**
 * @see RepositoryRestMvcConfiguration
 */
public class RepositoryRestMvcConfigurationCore {


    /**
     * @see RepositoryRestMvcConfiguration#restHandlerMapping(Repositories, RepositoryResourceMappings, Optional, RepositoryRestConfiguration, CorsConfigurationAware)
     */
    public void restHandlerMapping(Repositories repositories,
        RepositoryResourceMappings resourceMappings, Optional<JpaHelper> jpaHelper,
        RepositoryRestConfiguration repositoryRestConfiguration, CorsConfigurationAware corsRestConfiguration) {
    }
}
