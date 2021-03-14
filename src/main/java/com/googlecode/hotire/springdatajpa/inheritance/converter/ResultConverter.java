package com.googlecode.hotire.springdatajpa.inheritance.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.hotire.springdatajpa.inheritance.result.Result;

import lombok.SneakyThrows;

@Converter
public class ResultConverter implements AttributeConverter<Result, String> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(Result attribute) {
        return objectMapper.writeValueAsString(attribute);
    }

    @SneakyThrows
    @Override
    public Result convertToEntityAttribute(String dbData) {
        return objectMapper.readValue(dbData, new TypeReference<Result>() {});
    }
}
