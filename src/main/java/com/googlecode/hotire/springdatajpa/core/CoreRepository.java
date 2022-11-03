package com.googlecode.hotire.springdatajpa.core;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CoreRepository extends JpaRepository<Core, Long> {

    @Query(
        nativeQuery = true,
        value = "select * from core where id = :id"
    )
    Optional<Core> nativeFindById(Long id);
}
