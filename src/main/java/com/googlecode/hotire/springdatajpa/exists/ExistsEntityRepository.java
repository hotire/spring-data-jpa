package com.googlecode.hotire.springdatajpa.exists;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExistsEntityRepository extends JpaRepository<ExistsEntity, Long> {

    // limit 1
    boolean existsByName(String name);

//    @Query("SELECT EXIST (SELECT e.id FROM ExistsEntity e WHERE e.name =:name)") -> Validation failed for query for method public abstract boolean

    // 성능상 이슈
    @Query("SELECT COUNT(e.id) > 0 FROM ExistsEntity e WHERE e.name =:name")
    boolean existsByQuery(String name);
}
