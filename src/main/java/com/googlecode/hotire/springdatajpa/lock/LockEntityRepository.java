package com.googlecode.hotire.springdatajpa.lock;

import java.util.Optional;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

public interface LockEntityRepository extends JpaRepository<LockEntity, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query(value = "select l from LockEntity l where l.id = :id")
    @QueryHints({ @QueryHint(name = "javax.persistence.lock.timeout", value = "3000")})
    Optional<LockEntity> findByIdForUpdate(Long id);
}
