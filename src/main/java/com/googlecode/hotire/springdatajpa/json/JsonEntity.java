package com.googlecode.hotire.springdatajpa.json;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class JsonEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @Column(name = "json", columnDefinition = "json")
    @Convert(converter = JsonConverter.class)
    private List<Json> json;
}
