package com.googlecode.hotire.springdatajpa.json;

import java.util.List;

import javax.persistence.AttributeConverter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;

public class JsonConverter implements AttributeConverter<List<Json>, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(List<Json> attribute) {
        return objectMapper.writeValueAsString(attribute);
    }

    @SneakyThrows
    @Override
    public List<Json> convertToEntityAttribute(String dbData) {
        return objectMapper.readValue(dbData, new TypeReference<List<Json>>() {});
    }
}
