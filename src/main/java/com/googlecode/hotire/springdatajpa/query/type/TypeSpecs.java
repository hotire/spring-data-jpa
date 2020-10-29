package com.googlecode.hotire.springdatajpa.query.type;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TypeSpecs {
    TYPE("type"),
    OWNER("owner")
    ;
    private final String property;
}
