package com.googlecode.hotire.springdatajpa.dsl;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.googlecode.hotire.springdatajpa.ex.Account;
import com.googlecode.hotire.springdatajpa.ex.QAccount;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAUpdateClause;

/**
 *  학습 테스트
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountTest {

  @Autowired
  private EntityManager entityManager;

  @Test
  public void dynamic() {
    final QAccount account = QAccount.account;
    final BooleanBuilder booleanBuilder = new BooleanBuilder();

    booleanBuilder.and(account.username.eq("hotire"));

    final JPAQuery<Account> jpaQuery = new JPAQuery<>(entityManager);

    jpaQuery
        .from(account)
        .where(booleanBuilder)
        .select(account);
  }

  @Test
  public void update() {
    final QAccount account = QAccount.account;

    final JPAUpdateClause updateClause = new JPAUpdateClause(entityManager, account);

    updateClause.where(account.username.eq("hotire"))
        .set(account.age, account.age.add(1));
  }

}
