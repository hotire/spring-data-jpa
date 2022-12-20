package com.googlecode.hotire.springdatajpa.core.immutable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Immutable;

@Accessors(chain = true)
@Entity
@Getter
@Setter
@Immutable
public class ImmutableEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

}
