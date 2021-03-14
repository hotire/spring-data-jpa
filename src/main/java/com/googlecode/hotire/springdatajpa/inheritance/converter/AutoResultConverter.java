package com.googlecode.hotire.springdatajpa.inheritance.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.hotire.springdatajpa.inheritance.result.AutoResult;

import lombok.SneakyThrows;

@Converter
public class AutoResultConverter implements AttributeConverter<AutoResult, String> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(AutoResult attribute) {
        return objectMapper.writeValueAsString(attribute);
    }

    @SneakyThrows
    @Override
    public AutoResult convertToEntityAttribute(String dbData) {
        return objectMapper.readValue(dbData, new TypeReference<AutoResult>() {});
    }
}
