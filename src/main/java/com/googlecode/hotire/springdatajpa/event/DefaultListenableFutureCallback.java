package com.googlecode.hotire.springdatajpa.event;

import org.springframework.util.concurrent.ListenableFutureCallback;

public class DefaultListenableFutureCallback<T> implements ListenableFutureCallback<T> {
    @Override
    public void onFailure(Throwable ex) {
    }

    @Override
    public void onSuccess(T result) {
    }
}
