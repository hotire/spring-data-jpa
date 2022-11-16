package com.googlecode.hotire.springdatajpa.core.repository.method;

import javax.persistence.EntityManager;
import org.springframework.data.jpa.provider.QueryExtractor;
import org.springframework.data.jpa.repository.query.EscapeCharacter;
import org.springframework.data.jpa.repository.query.JpaQueryLookupStrategy;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.data.repository.query.QueryLookupStrategy.Key;
import org.springframework.data.repository.query.QueryMethodEvaluationContextProvider;
import org.springframework.lang.Nullable;

/***
 * @see org.springframework.data.jpa.repository.query.JpaQueryLookupStrategy
 * @see org.springframework.data.jpa.repository.query.JpaQueryLookupStrategy.DeclaredQueryLookupStrategy
 */
public class JpaQueryLookupStrategyCore {

    /**
     * @see JpaQueryLookupStrategy#create(EntityManager, Key, QueryExtractor, QueryMethodEvaluationContextProvider, EscapeCharacter)
     */
    public static QueryLookupStrategy create(
        EntityManager em, @Nullable Key key, QueryExtractor extractor,
        QueryMethodEvaluationContextProvider evaluationContextProvider, EscapeCharacter escape) {
        return JpaQueryLookupStrategy.create(em, key, extractor, evaluationContextProvider, escape);
    }
}
