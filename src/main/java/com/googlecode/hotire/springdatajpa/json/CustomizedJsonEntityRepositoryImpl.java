package com.googlecode.hotire.springdatajpa.json;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomizedJsonEntityRepositoryImpl implements CustomizedJsonEntityRepository {

    private final EntityManager entityManager;
    private final ObjectMapper objectMapper;

    @Getter
    @RequiredArgsConstructor
    public class Age {
        private final Integer age;
        public String toJson() {
            try {
                return objectMapper.writeValueAsString(this);
            } catch (final JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<JsonEntity> findByAge(final Integer age) {
        final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<JsonEntity> query = builder.createQuery(JsonEntity.class);
        final Root<JsonEntity> root = query.from(JsonEntity.class);

        final var where = builder.equal(
                builder.function("JSON_CONTAINS",
                                 Boolean.class,
                                 root.get("json"),
                                 builder.literal(new Age(age).toJson())
                ), true);
        query.select(root).where(where);
        final TypedQuery<JsonEntity> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
}
