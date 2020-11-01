package com.googlecode.hotire.springdatajpa.event;

import java.util.function.Consumer;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@Getter
public class ItemEvent extends ApplicationEvent implements EventCallbackAware<Item> {
    private final Item item;
    private final Consumer<Item> consumer;
    private EventCallback<Item> eventCallback;

    public ItemEvent(final Item item) {
        this(item, it -> {});
    }

    public ItemEvent(final Item item, final Consumer<Item> consumer) {
        super(item);
        this.item = item;
        this.consumer = consumer;
    }

    @Override
    public EventCallbackAware<Item> setCallback(EventCallback<Item> eventCallback) {
        this.eventCallback = eventCallback;
        return this;
    }
}
