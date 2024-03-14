package com.googlecode.hotire.springdatajpa.core.scan;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.data.repository.util.ClassUtils;

/**
 * @see org.springframework.data.repository.config.RepositoryComponentProvider
 */
public class RepositoryComponentProviderCore {


    /**
     * @see org.springframework.data.repository.config.RepositoryComponentProvider#isCandidateComponent(MetadataReader) 
     */
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {

        boolean isNonRepositoryInterface = !ClassUtils.isGenericRepositoryInterface(beanDefinition.getBeanClassName());
        boolean isTopLevelType = !beanDefinition.getMetadata().hasEnclosingClass();
//        boolean isConsiderNestedRepositories = isConsiderNestedRepositoryInterfaces();
        boolean isConsiderNestedRepositories = true;

        return isNonRepositoryInterface && (isTopLevelType || isConsiderNestedRepositories);
    }

}
