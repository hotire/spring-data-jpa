package com.googlecode.hotire.springdatajpa.audit;

import javax.persistence.Entity;

import org.apache.logging.log4j.util.Strings;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
@Entity
public class Food extends AuditEntity<Long> {
    private String name;
    private String legacyId;

    @Override
    public boolean isAuditable() {
        return Strings.isNotEmpty(legacyId);
    }
}
