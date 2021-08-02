package com.googlecode.hotire.springdatajpa.dsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.googlecode.hotire.springdatajpa.ex.Account;
import com.googlecode.hotire.springdatajpa.ex.QAccount;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

/**
 * https://jojoldu.tistory.com/372
 * https://www.baeldung.com/querydsl-with-jpa-tutorial
 * http://www.querydsl.com/static/querydsl/4.0.1/reference/ko-KR/html_single/
 */
@Repository
@RequiredArgsConstructor
public class AccountRepositorySupport  {

  private final JPAQueryFactory jpaQueryFactory;

  public List<Account> findByName(final String name) {
    return jpaQueryFactory.selectFrom(QAccount.account).where(QAccount.account.username.eq(name)).fetch();
  }
}
