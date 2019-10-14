package com.googlecode.hotire.springdatajpa.dsl;

import static com.googlecode.hotire.springdatajpa.QAccount.account;

import com.googlecode.hotire.springdatajpa.Account;
import com.googlecode.hotire.springdatajpa.QAccount;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * https://jojoldu.tistory.com/372
 * https://www.baeldung.com/querydsl-with-jpa-tutorial
 */
@Repository
public class AccountRepositorySupport  {

  @Autowired(required = false)
  private JPAQueryFactory jpaQueryFactory;

  public List<Account> findByName(String name) {
    return jpaQueryFactory.selectFrom(QAccount.account).where(account.username.eq(name)).fetch();
  }
}
