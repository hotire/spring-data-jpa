package com.googlecode.hotire.springdatajpa.audit;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class CustomAuditingEntityListener {
    private final AuditingEntityListener delegate;

    @PrePersist
    public void touchForCreate(Object target) {
        delegate.touchForCreate(target);
    }

    @PreUpdate
    public void touchForUpdate(Object target) {
        delegate.touchForUpdate(target);
    }

}
