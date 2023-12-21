package com.googlecode.hotire.springdatajpa.core.bootstrap;


import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.repository.Repository;

/**
 * @see org.springframework.data.repository.config.DeferredRepositoryInitializationListener
 */
@RequiredArgsConstructor
public class DeferredRepositoryInitializationListenerCore {
    private static final Log logger = LogFactory.getLog(DeferredRepositoryInitializationListenerCore.class);
    private final ListableBeanFactory beanFactory;

    /**
     * @see org.springframework.data.repository.config.DeferredRepositoryInitializationListener#onApplicationEvent(ContextRefreshedEvent) 
     */
    public void onApplicationEvent(ContextRefreshedEvent event) {

        logger.info("Triggering deferred initialization of Spring Data repositories…");

        beanFactory.getBeansOfType(Repository.class);

        logger.info("Spring Data repositories initialized!");
    }

}
