package com.googlecode.hotire.springdatajpa.event;

public interface EventPublisher<T extends EventPublisher<T>> {

    <E> E publish(final E event);

    @SuppressWarnings("unchecked")
    default T publish() {
        publish(getEvent());
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T publish(final EventCallback<T> callback) {
        publish(getEvent().setCallback(callback));
        return (T) this;
    }

    EventCallbackAware<T> getEvent();
}
