package com.googlecode.hotire.springdatajpa.audit;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class CustomAuditingEntityListener {
    private final AuditingEntityListener delegate;
}
