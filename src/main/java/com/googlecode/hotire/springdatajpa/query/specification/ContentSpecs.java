package com.googlecode.hotire.springdatajpa.query.specification;

import org.springframework.data.jpa.domain.Specification;

public class ContentSpecs {
    public static Specification<Content> withName(String name) {
        return (Specification<Content>) ((root, query, builder) ->
                builder.equal(root.get("name"), name)
        );
    }
}
