package com.googlecode.hotire.springdatajpa.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ThreadUtils {

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> Future<T> newThreadSubmit(Callable<T> callable) {
        return Executors.newSingleThreadExecutor().submit(callable);
    }
}
