package com.googlecode.hotire.springdatajpa.query.type;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum OwnerSpecs {
    NAME("name"),
    OWNER_ID("ownerId")
    ;
    private final String property;
}
