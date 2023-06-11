package com.googlecode.hotire.springdatajpa.rest.core;

import org.springframework.core.MethodParameter;
import org.springframework.data.rest.webmvc.config.PersistentEntityResourceHandlerMethodArgumentResolver;
import org.springframework.data.rest.webmvc.config.RootResourceInformationHandlerMethodArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @see PersistentEntityResourceHandlerMethodArgumentResolver
 */
public class PersistentEntityResourceHandlerMethodArgumentResolverCore {

    /**
     * @see PersistentEntityResourceHandlerMethodArgumentResolver#resourceInformationResolver
     */
    private RootResourceInformationHandlerMethodArgumentResolver resourceInformationHandlerMethodArgumentResolver;

    /**
     * @see PersistentEntityResourceHandlerMethodArgumentResolver#resolveArgument(MethodParameter, ModelAndViewContainer, NativeWebRequest, WebDataBinderFactory)
     */
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
        NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return null;
    }

}
