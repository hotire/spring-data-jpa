package com.googlecode.hotire.springdatajpa.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "data-rest")
public interface DataRestRepository extends JpaRepository<DataRest, Long> {

}

