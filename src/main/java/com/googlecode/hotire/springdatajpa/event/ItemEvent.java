package com.googlecode.hotire.springdatajpa.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class ItemEvent extends ApplicationEvent {
    private final Item item;

    public ItemEvent(Item item) {
        super(item);
        this.item = item;
    }
}
