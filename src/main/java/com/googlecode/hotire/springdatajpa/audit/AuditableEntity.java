package com.googlecode.hotire.springdatajpa.audit;

public interface AuditableEntity {
    Boolean isAuditable();

    static Boolean isAuditable(final Object target) {
        if (target instanceof AuditableEntity) {
            return ((AuditableEntity) target).isAuditable();
        }
        return true;
    }
}
