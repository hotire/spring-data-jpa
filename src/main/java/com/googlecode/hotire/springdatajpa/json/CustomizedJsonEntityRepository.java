package com.googlecode.hotire.springdatajpa.json;

import java.util.List;

public interface CustomizedJsonEntityRepository {
    List<JsonEntity> findByAge(Integer age);
}
