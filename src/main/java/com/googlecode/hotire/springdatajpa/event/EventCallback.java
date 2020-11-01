package com.googlecode.hotire.springdatajpa.event;

import java.util.function.Consumer;

import lombok.Builder;

@Builder
public class EventCallback<T> {
    @Builder.Default private final Consumer<T> beforeCommit = t -> {};
    @Builder.Default private final Consumer<T> afterCommit = t -> {};
    @Builder.Default private final Consumer<T> afterRollback = t -> {};
    @Builder.Default private final Consumer<T> afterCompletion = t -> {};
}
