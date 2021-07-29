package com.googlecode.hotire.springdatajpa.json;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Json {
    private String name;
    private Integer age;
}
