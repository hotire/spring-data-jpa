package com.googlecode.hotire.springdatajpa.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.function.Consumer;

@Getter
public class ItemEvent extends ApplicationEvent {
    private final Item item;
    private final Consumer<Item> consumer;

    public ItemEvent(final Item item) {
        this(item, it -> {});
    }

    public ItemEvent(final Item item, final Consumer<Item> consumer) {
        super(item);
        this.item = item;
        this.consumer = consumer;
    }

}
