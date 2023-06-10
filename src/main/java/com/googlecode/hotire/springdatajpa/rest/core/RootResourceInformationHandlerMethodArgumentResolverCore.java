package com.googlecode.hotire.springdatajpa.rest.core;

import org.springframework.core.MethodParameter;
import org.springframework.data.rest.webmvc.RootResourceInformation;
import org.springframework.data.rest.webmvc.config.RootResourceInformationHandlerMethodArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @see RootResourceInformationHandlerMethodArgumentResolver
 */
public class RootResourceInformationHandlerMethodArgumentResolverCore {

    /**
     * @see RootResourceInformationHandlerMethodArgumentResolver#resolveArgument(MethodParameter, ModelAndViewContainer, NativeWebRequest, WebDataBinderFactory) 
     */
    public RootResourceInformation resolveArgument(
        MethodParameter parameter, ModelAndViewContainer mavContainer,
        NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return null;
    }
}
