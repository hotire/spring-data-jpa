package com.googlecode.hotire.springdatajpa.dsl;

import static com.googlecode.hotire.springdatajpa.QAccount.account;

import com.googlecode.hotire.springdatajpa.Account;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * https://jojoldu.tistory.com/372
 */
@Repository
public class AccountRepositorySupport  {

  @Autowired(required = false)
  JPAQueryFactory jpaQueryFactory;

  public List<Account> findByName(String name) {
    return jpaQueryFactory.selectFrom(account).where(account.username.eq(name)).fetch();
  }
}
