package com.googlecode.hotire.springdatajpa.audit;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditEntity<ID extends Serializable> extends Entity<ID>{

    @CreatedDate
    private OffsetDateTime createdDate;

    @LastModifiedDate
    private OffsetDateTime modifiedDate;

    @LastModifiedBy
    private String updatedBy;

    @CreatedBy
    private String createdBy;

    public AuditEntity<ID> setCreatedDate(final OffsetDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }
}
