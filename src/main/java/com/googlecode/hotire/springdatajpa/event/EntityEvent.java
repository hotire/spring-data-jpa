package com.googlecode.hotire.springdatajpa.event;

import org.springframework.context.ApplicationEvent;

import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class EntityEvent extends ApplicationEvent {
    private final BaseEntity baseBaseEntity;

    public EntityEvent(Object source) {
        super(source);
        this.baseBaseEntity = (BaseEntity) source;
    }

}
