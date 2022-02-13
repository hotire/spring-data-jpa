package com.googlecode.hotire.springdatajpa.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;

import lombok.Builder;
import lombok.Getter;

/**
 * 
 * @see ApplicationEventPublisher#publishEvent(Object)  , ApplicationEvent 사용하지 않을 경우, PayloadApplicationEvent로 매핑된다. 
 */
@Builder
@Getter
public class EntityEvent extends ApplicationEvent {
    private final BaseEntity baseBaseEntity;

    public EntityEvent(final Object source) {
        super(source);
        baseBaseEntity = (BaseEntity) source;
    }

}
