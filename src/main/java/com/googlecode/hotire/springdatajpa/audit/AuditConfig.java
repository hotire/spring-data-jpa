package com.googlecode.hotire.springdatajpa.audit;

import java.time.OffsetDateTime;
import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.AuditingHandler;
import org.springframework.data.auditing.DateTimeProvider;

@Configuration
public class AuditConfig {

    @Bean
    public DateTimeProvider dateTimeProvider(final AuditingHandler auditingHandler) {
        final DateTimeProvider dateTimeProvider = () -> Optional.of(OffsetDateTime.now());
        auditingHandler.setDateTimeProvider(dateTimeProvider);
        return dateTimeProvider;
    }
}
