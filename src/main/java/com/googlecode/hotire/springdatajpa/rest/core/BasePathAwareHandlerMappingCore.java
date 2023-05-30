package com.googlecode.hotire.springdatajpa.rest.core;

import java.util.Map;
import java.util.function.Predicate;
import org.springframework.data.rest.webmvc.BasePathAwareHandlerMapping;

/**
 * @see BasePathAwareHandlerMapping
 */
public class BasePathAwareHandlerMappingCore {


    /**
     * @see BasePathAwareHandlerMapping#setPathPrefixes(Map)
     */
    public void setPathPrefixes(Map<String, Predicate<Class<?>>> prefixes) {
    }
}
