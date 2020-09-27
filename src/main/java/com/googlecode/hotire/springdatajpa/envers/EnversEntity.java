package com.googlecode.hotire.springdatajpa.envers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Id;

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
