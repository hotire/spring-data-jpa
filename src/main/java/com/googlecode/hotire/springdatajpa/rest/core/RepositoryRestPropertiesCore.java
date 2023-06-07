package com.googlecode.hotire.springdatajpa.rest.core;

import org.springframework.boot.autoconfigure.data.rest.RepositoryRestProperties;
import org.springframework.data.rest.core.mapping.RepositoryDetectionStrategy.RepositoryDetectionStrategies;

/**
 * @see RepositoryRestProperties
 */
public class RepositoryRestPropertiesCore {


    /**
     * @see RepositoryRestProperties#detectionStrategy
     */
    private RepositoryDetectionStrategies detectionStrategy = RepositoryDetectionStrategies.DEFAULT;
}
