package com.googlecode.hotire.springdatajpa.core.repository.method;

import lombok.RequiredArgsConstructor;

/**
 * @see org.springframework.data.jpa.repository.query.AbstractStringBasedJpaQuery;
 */
@RequiredArgsConstructor
public class AbstractStringBasedJpaQueryCore {

    /**
     * @see org.springframework.data.jpa.repository.query.DeclaredQuery
     */
    private final DeclaredQueryCore countQuery;
}
