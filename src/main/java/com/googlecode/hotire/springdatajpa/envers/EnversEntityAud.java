package com.googlecode.hotire.springdatajpa.envers;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

//@Data
//@Entity
public class EnversEntityAud {

    @EmbeddedId
    private EnversEntityAudId enversEntityAudId;

    private String name;

    private Integer age;

}
