package com.googlecode.hotire.springdatajpa.save;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersistableCoreEntityRepository extends JpaRepository<PersistableCoreEntity, Long> {

}
