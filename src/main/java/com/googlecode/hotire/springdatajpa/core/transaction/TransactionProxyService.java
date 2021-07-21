package com.googlecode.hotire.springdatajpa.core.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransactionProxyService {

    @Transactional
    public void run(final Runnable runnable) {
        runnable.run();
    }
}
