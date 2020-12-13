package com.googlecode.hotire.springdatajpa.audit;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.googlecode.hotire.springdatajpa.Entity;

import lombok.Getter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@MappedSuperclass
@EntityListeners(CustomAuditingEntityListener.class)
public class AuditEntity<ID extends Serializable> extends Entity<ID> implements AuditableEntity {

    @CreatedDate
    private OffsetDateTime createdDate;
    @LastModifiedDate
    private OffsetDateTime modifiedDate;

    private OffsetDateTime remoteDate;

    @LastModifiedBy
    private String updatedBy;

    @CreatedBy
    private String createdBy;

    public AuditEntity<ID> setCreatedDate(final OffsetDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public AuditEntity<ID> setModifiedDate(final OffsetDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public AuditEntity<ID> setUpdatedBy(final String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public AuditEntity<ID> setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    @Override
    public boolean isAuditable() {
        return true;
    }
}
