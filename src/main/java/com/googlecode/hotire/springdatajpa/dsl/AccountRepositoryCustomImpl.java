package com.googlecode.hotire.springdatajpa.dsl;

import static com.googlecode.hotire.springdatajpa.QAccount.account;

import com.googlecode.hotire.springdatajpa.Account;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class AccountRepositoryCustomImpl extends QuerydslRepositorySupport implements AccountRepositoryCustom {

  public AccountRepositoryCustomImpl() {
    super(Account.class);
  }

  @Override
  public List<Account> findByName(String name) {
    return from(account).where(account.username.eq(name)).fetch();
  }

}
