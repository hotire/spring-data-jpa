package com.googlecode.hotire.springdatajpa.query.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OwnerSpecs implements Specs {
    NAME("name"),
    OWNER_ID("ownerId")
    ;
    private final String property;
}

