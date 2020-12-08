package com.googlecode.hotire.springdatajpa.audit;

public interface AuditableEntity {
    boolean isAuditable();

    static boolean isAuditable(final Object target) {
        if (target instanceof AuditableEntity) {
            return ((AuditableEntity) target).isAuditable();
        }
        return true;
    }
}
