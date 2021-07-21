package com.googlecode.hotire.springdatajpa.core.transaction;

import org.springframework.transaction.interceptor.TransactionAspectSupport;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TransactionAspectSupportDecorator {
    private final TransactionAspectSupport delegate;
}
