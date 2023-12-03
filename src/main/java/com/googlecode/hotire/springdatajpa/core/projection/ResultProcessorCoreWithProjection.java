package com.googlecode.hotire.springdatajpa.core.projection;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.repository.query.ResultProcessor;
import org.springframework.lang.Nullable;

/**
 * @see ResultProcessor
 */
public class ResultProcessorCoreWithProjection {


    /**
     * @see ResultProcessor#processResult(Object, Converter) 
     */
    public <T> T processResult(@Nullable Object source, Converter<Object, Object> preparingConverter) {
        return null;
    }



    /**
     * @see ResultProcessor.ProjectingConverter
     */
    static class ProjectingConverter {

    }

}
