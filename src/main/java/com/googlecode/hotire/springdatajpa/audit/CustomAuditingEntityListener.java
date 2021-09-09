package com.googlecode.hotire.springdatajpa.audit;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

public class CustomAuditingEntityListener {
    @Autowired
    private AuditingEntityListener delegate;

    @PrePersist
    public void touchForCreate(final Object target) {
        if (AuditableEntity.isAuditable(target)) {
            delegate.touchForCreate(target);
        }
    }

    @PreUpdate
    public void touchForUpdate(final Object target) {
        if (AuditableEntity.isAuditable(target)) {
            delegate.touchForUpdate(target);
        }
    }
}
