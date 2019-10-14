package com.googlecode.hotire.springdatajpa;

import com.googlecode.hotire.springdatajpa.dsl.AccountRepositoryCustom;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Long>, AccountRepositoryCustom {

  @Query("select a from Account a join fetch a.studies")
  Set<Account> findAllJoinFetch();

  @Query("select a from Account a left outer join Study s on a.id = s.owner.id")
  List<Account> findAllJoinLeft();

  @EntityGraph(attributePaths = "studies")
  @Query("select a from Account a")
  List<Account> findAllEntityGraph();
}
