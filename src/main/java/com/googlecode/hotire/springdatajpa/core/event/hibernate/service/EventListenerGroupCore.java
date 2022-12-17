package com.googlecode.hotire.springdatajpa.core.event.hibernate.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.hibernate.event.service.spi.EventActionWithParameter;
import org.hibernate.event.service.spi.EventListenerGroup;

/**
 * @see EventListenerGroup
 * @see org.hibernate.event.service.internal.EventListenerGroupImpl
 * @see org.hibernate.event.service.internal.PostCommitEventListenerGroupImpl
 */
public class EventListenerGroupCore<T> {

    private static final CompletableFuture COMPLETED = CompletableFuture.completedFuture( null );

    /**
     * @see org.hibernate.event.service.internal.EventListenerGroupImpl#listeners
     */
    private T[] listeners = null;


    /**
     * @see EventListenerGroup#appendListener(Object)
     */
    public void appendListener(T listener) {
    }

    /**
     * @see EventListenerGroup#fireEventOnEachListener(Object, BiConsumer) 
     */
    public <U> void fireEventOnEachListener(final U event, final BiConsumer<T,U> actionOnEvent) {

    }


    /**
     * @see EventListenerGroup#fireEventOnEachListener(Object, Object, EventActionWithParameter)
     */
    public <U,X> void fireEventOnEachListener(final U event, X param, final EventActionWithParameter<T,U,X> actionOnEvent) {

    }


    /**
     * @see org.hibernate.event.service.internal.EventListenerGroupImpl#fireLazyEventOnEachListener(Supplier, Function)
     */
    public <R, U, RL> CompletionStage<R> fireLazyEventOnEachListener(
        final Supplier<U> eventSupplier,
        final Function<RL, Function<U, CompletionStage<R>>> fun) {
        return COMPLETED;
    }
}
