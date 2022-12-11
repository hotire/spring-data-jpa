package com.googlecode.hotire.springdatajpa.core.transaction;

import java.util.concurrent.Callable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionDelegator {

    @Transactional
    public <T> T transaction(Callable<T> callable) {
        try {
            return callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
