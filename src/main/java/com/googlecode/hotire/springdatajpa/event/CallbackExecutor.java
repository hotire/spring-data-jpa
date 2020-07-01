package com.googlecode.hotire.springdatajpa.event;

import org.springframework.util.concurrent.ListenableFutureCallback;

public class CallbackExecutor {
    public static <T> void execute(final ListenableFutureCallback<T> callback, final T target) {
        try {
            callback.onSuccess(target);
        } catch (Throwable e) {
            callback.onFailure(e);
        }
    }
}
