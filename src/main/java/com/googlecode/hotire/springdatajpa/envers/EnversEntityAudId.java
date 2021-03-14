package com.googlecode.hotire.springdatajpa.envers;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class EnversEntityAudId implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long rev;
    private Long id;
}
