package com.googlecode.hotire.springdatajpa;

import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Long> {

  @Query("select a from Account a join fetch a.studies")
  Set<Account> findAllJoinFetch();

  @EntityGraph(attributePaths = "studies")
  List<Account> findAll();
}
