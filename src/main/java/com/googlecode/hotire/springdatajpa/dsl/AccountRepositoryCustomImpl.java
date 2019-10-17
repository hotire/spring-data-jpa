package com.googlecode.hotire.springdatajpa.dsl;

import com.googlecode.hotire.springdatajpa.Account;
import com.googlecode.hotire.springdatajpa.QAccount;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class AccountRepositoryCustomImpl extends QuerydslRepositorySupport implements
  AccountRepositoryCustom {

  public AccountRepositoryCustomImpl() {
    super(Account.class);
  }

  @Override
  public List<Account> findByName(String name) {
    return from(QAccount.account).where(QAccount.account.username.eq(name)).fetch();
  }

}
