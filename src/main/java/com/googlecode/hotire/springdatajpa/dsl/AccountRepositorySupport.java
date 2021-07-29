package com.googlecode.hotire.springdatajpa.dsl;

import static com.googlecode.hotire.springdatajpa.QAccount.account;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.googlecode.hotire.springdatajpa.QAccount;
import com.googlecode.hotire.springdatajpa.ex.Account;
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
    return jpaQueryFactory.selectFrom(QAccount.account).where(account.username.eq(name)).fetch();
  }
}
