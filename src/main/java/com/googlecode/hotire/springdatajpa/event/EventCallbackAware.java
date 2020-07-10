package com.googlecode.hotire.springdatajpa.event;

public interface EventCallbackAware<T> {
    EventCallbackAware<T> setCallback(final EventCallback<T> eventCallback);
}
