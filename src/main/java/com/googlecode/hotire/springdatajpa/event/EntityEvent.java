package com.googlecode.hotire.springdatajpa.event;

import lombok.Builder;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;


@Builder
@Getter
public class EntityEvent extends ApplicationEvent {
    private final BaseEntity baseBaseEntity;

    public EntityEvent(Object source) {
        super(source);
        this.baseBaseEntity = (BaseEntity) source;
    }

}
