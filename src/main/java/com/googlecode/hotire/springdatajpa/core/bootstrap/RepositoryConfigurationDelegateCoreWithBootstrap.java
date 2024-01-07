package com.googlecode.hotire.springdatajpa.core.bootstrap;

import java.util.Map;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.data.repository.config.BootstrapMode;
import org.springframework.data.repository.config.RepositoryConfiguration;
import org.springframework.data.repository.config.RepositoryConfigurationDelegate;

/**
 * @see RepositoryConfigurationDelegate
 */
public class RepositoryConfigurationDelegateCoreWithBootstrap {


    /**
     * @see RepositoryConfigurationDelegate#potentiallyLazifyRepositories(Map, BeanDefinitionRegistry, BootstrapMode)
     */
    private static void potentiallyLazifyRepositories(
        Map<String, RepositoryConfiguration<?>> configurations,
        BeanDefinitionRegistry registry, BootstrapMode mode) {

    }
}
