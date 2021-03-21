package com.googlecode.hotire.springdatajpa.core.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class TransactionInnerService {
    private final TransactionRepository transactionRepository;
}
