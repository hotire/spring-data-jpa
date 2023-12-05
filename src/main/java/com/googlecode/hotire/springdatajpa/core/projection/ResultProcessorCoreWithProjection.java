package com.googlecode.hotire.springdatajpa.core.projection;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.repository.query.ResultProcessor;
import org.springframework.data.repository.query.ReturnedType;
import org.springframework.lang.Nullable;

/**
 * @see ResultProcessor
 */
public class ResultProcessorCoreWithProjection {


    /**
     * @see ResultProcessor#processResult(Object, Converter)
     *
     * @see org.hibernate.jpa.spi.CriteriaQueryTupleTransformer.TupleImpl
     * case projection : source is TupleImpl
     * case entity : source is entity
     */
    public <T> T processResult(@Nullable Object source, Converter<Object, Object> preparingConverter) {
        return null;
    }


    /**
     * @see ResultProcessor.ProjectingConverter
     */
    @RequiredArgsConstructor
    static class ProjectingConverter {
        private final ReturnedType type;
        /**
         * @see org.springframework.data.projection.ProjectionFactory;
         */
        private final ProjectionFactory factory;

        /**
         * @see ResultProcessor.ProjectingConverter#convert(Object)
         */
        public Object convert(Object source) {
            return null;
        }
    }

}
