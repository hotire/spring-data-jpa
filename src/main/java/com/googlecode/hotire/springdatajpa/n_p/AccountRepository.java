package com.googlecode.hotire.springdatajpa.n_p;

import com.googlecode.hotire.springdatajpa.Account;
import com.googlecode.hotire.springdatajpa.dsl.AccountRepositoryCustom;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;
import java.util.Set;

/**
 * N +1
 */
public interface AccountRepository extends JpaRepository<Account, Long>, AccountRepositoryCustom,
                                           QuerydslPredicateExecutor {

  /**
   * Fetch Join
   */
  @Query("select a from Account a join fetch a.studies")
  Set<Account> findAllJoinFetch();

  @Query("select a from Account a left outer join Study s on a.id = s.owner.id")
  List<Account> findAllJoinLeft();

  /**
   * EntityGraph
   */
  @EntityGraph(attributePaths = "studies")
  @Query("select a from Account a")
  List<Account> findAllEntityGraph();
}