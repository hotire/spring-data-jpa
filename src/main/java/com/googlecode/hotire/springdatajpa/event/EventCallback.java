package com.googlecode.hotire.springdatajpa.event;

import lombok.Builder;

import java.util.function.Consumer;

@Builder
public class EventCallback<T> {
    @Builder.Default private final Consumer<T> beforeCommit = t -> {};
    @Builder.Default private final Consumer<T> afterCommit = t -> {};
    @Builder.Default private final Consumer<T> afterRollback = t -> {};
    @Builder.Default private final Consumer<T> afterCompletion = t -> {};
}
