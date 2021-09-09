package com.googlecode.hotire.springdatajpa.event_listener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
@EntityListeners(CustomEntityListener.class)
public class EntityListenersEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
