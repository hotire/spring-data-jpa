package com.googlecode.hotire.springdatajpa.n_p;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.googlecode.hotire.springdatajpa.dsl.AccountRepositoryCustom;
import com.googlecode.hotire.springdatajpa.ex.Account;

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
  
  @Query("select a from Account a join fetch a.studies")
  List<Account> findAllByCartasian();

  @Query("select a from Account a left outer join Study s on a.id = s.owner.id")
  List<Account> findAllJoinLeft();

  /**
   * EntityGraph
   */
  @EntityGraph(attributePaths = "studies")
  @Query("select a from Account a")
  List<Account> findAllEntityGraph();

  @EntityGraph(attributePaths = "studies")
  List<Account> findByUsername(String userName);


}
