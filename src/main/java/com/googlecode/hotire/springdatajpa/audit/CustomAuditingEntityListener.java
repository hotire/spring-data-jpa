package com.googlecode.hotire.springdatajpa.audit;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Configuration
public class CustomAuditingEntityListener {
    @Autowired
    private AuditingEntityListener delegate;

    @PrePersist
    public void touchForCreate(Object target) {
        delegate.touchForCreate(target);
    }

    @PreUpdate
    public void touchForUpdate(Object target) {
        delegate.touchForUpdate(target);
    }

}
