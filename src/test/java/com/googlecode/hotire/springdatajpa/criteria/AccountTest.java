package com.googlecode.hotire.springdatajpa.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.googlecode.hotire.springdatajpa.ex.Account;

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

  @Test
  public void subquery() {
    final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    final CriteriaQuery<Account> criteriaQuery = cb.createQuery(Account.class);

    final Subquery<Double> subquery = criteriaQuery.subquery(Double.class);

    final Root<Account> a2 = subquery.from(Account.class);

    subquery.select(cb.avg(a2.<Integer>get("age")));

    final Root<Account> a = criteriaQuery.from(Account.class);
    criteriaQuery.select(a)
        .where(cb.ge(a.<Integer>get("age"), subquery));

    final List<Account> accounts = entityManager.createQuery(criteriaQuery).getResultList();
  }

  @Test
  public void in() {
    final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    final CriteriaQuery<Account> criteriaQuery = cb.createQuery(Account.class);

    final Root<Account> accountRoot = criteriaQuery.from(Account.class);               // FROM

    criteriaQuery
        .select(accountRoot)
        .where(cb.in(accountRoot.get("username")).value("hotire"));

    final List<Account> accounts = entityManager.createQuery(criteriaQuery).getResultList();
  }

  @Test
  public void parameter() {
    final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    final CriteriaQuery<Account> criteriaQuery = cb.createQuery(Account.class);

    final Root<Account> accountRoot = criteriaQuery.from(Account.class);               // FROM

    criteriaQuery
        .select(accountRoot)
        .where(cb.equal(accountRoot.get("username"), cb.parameter(String.class, "usernameParameter")));

    final List<Account> accounts = entityManager.createQuery(criteriaQuery)
        .setParameter("usernameParameter", "회원1")
        .getResultList();
  }
}
