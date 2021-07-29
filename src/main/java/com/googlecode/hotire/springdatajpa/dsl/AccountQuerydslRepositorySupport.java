package com.googlecode.hotire.springdatajpa.dsl;

import static com.googlecode.hotire.springdatajpa.QAccount.account;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.googlecode.hotire.springdatajpa.QAccount;
import com.googlecode.hotire.springdatajpa.ex.Account;

@Repository
public class AccountQuerydslRepositorySupport extends QuerydslRepositorySupport {

  public AccountQuerydslRepositorySupport() {
    super(Account.class);
  }

  public List<Account> findByName(final String name) {
    return from(QAccount.account).where(account.username.eq(name)).fetch();
  }
}

