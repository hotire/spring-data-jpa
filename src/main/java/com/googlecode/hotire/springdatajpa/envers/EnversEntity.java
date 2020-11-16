package com.googlecode.hotire.springdatajpa.envers;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.envers.Audited;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * https://github.com/hibernate/hibernate-orm/blob/master/hibernate-envers/src/main/java/org/hibernate/envers/DefaultRevisionEntity.java
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Audited
public class EnversEntity {
    @Id
    private Long id;

    private String name;

    private Integer age;
}
