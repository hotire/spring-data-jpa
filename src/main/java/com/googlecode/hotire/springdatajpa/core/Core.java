package com.googlecode.hotire.springdatajpa.core;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.kafka.common.protocol.types.Field.Str;

@Setter
@Getter
@Entity
@Accessors(chain = true)
public class Core {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Access(AccessType.FIELD)
    private String name;

    private Integer age;
}
