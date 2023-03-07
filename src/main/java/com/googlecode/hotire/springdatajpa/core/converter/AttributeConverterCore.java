package com.googlecode.hotire.springdatajpa.core.converter;

import javax.persistence.AttributeConverter;

/**
 * @see AttributeConverter
 */
public interface AttributeConverterCore<X, Y> {

    /**
     * @see AttributeConverter#convertToDatabaseColumn(Object) 
     */

    Y convertToDatabaseColumn (X attribute);

    /**
     * @see AttributeConverter#convertToEntityAttribute(Object) 
     */
    X convertToEntityAttribute (Y dbData);
}
