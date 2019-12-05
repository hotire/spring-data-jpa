package com.googlecode.hotire.springdatajpa.criteria;


import com.googlecode.hotire.springdatajpa.Account;
import com.googlecode.hotire.springdatajpa.Study;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *  학습 테스트
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountTest {

  @Autowired
  private EntityManager entityManager;

  @Test
  public void findAll() {
    final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    final CriteriaQuery<Account> criteriaQuery = cb.createQuery(Account.class);

    final Root<Account> accountRoot = criteriaQuery.from(Account.class);  // FROM
    criteriaQuery.select(accountRoot);                                    // SELECT

    final TypedQuery<Account> query = entityManager.createQuery(criteriaQuery);
    final List<Account> accounts = query.getResultList();
  }

  @Test
  public void whereAndOrderBy() {
    final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    final CriteriaQuery<Account> criteriaQuery = cb.createQuery(Account.class);

    final Root<Account> accountRoot = criteriaQuery.from(Account.class);               // FROM

    // 검색 조건
    final Predicate predicate = cb.equal(accountRoot.get("username"), "hotire");
    // 정렬 조건
    final Order nameDesc = cb.desc(accountRoot.get("username"));

    criteriaQuery
        .select(accountRoot)
        .where(predicate)     // WHERE
        .orderBy(nameDesc);   // ORDER BY

    final List<Account> accounts = entityManager.createQuery(criteriaQuery).getResultList();
   }

   @Test
   public void join() {
     final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
     final CriteriaQuery<Account> criteriaQuery = cb.createQuery(Account.class);

     final Root<Account> accountRoot = criteriaQuery.from(Account.class);               // FROM

     accountRoot.join("studies");

     criteriaQuery.select(accountRoot);

     final List<Account> accounts = entityManager.createQuery(criteriaQuery).getResultList();
   }

  @Test
  public void leftJoin() {
    final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    final CriteriaQuery<Account> criteriaQuery = cb.createQuery(Account.class);

    final Root<Account> accountRoot = criteriaQuery.from(Account.class);               // FROM

    accountRoot.join("studies", JoinType.LEFT);

    criteriaQuery
        .select(accountRoot);

    final List<Account> accounts = entityManager.createQuery(criteriaQuery).getResultList();
  }
}
