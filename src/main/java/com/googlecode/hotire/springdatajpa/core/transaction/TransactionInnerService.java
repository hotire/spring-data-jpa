package com.googlecode.hotire.springdatajpa.core.transaction;

import java.util.function.Consumer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class TransactionInnerService {
    private final TransactionRepository transactionRepository;

    public void service(Runnable runnable) {
        runnable.run();;
    }

    public void service(final Transaction transaction, final Consumer<Transaction> consumer) {
        consumer.accept(transaction);
    }
}
