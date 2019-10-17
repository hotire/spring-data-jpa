package com.googlecode.hotire.springdatajpa.dsl;

import static com.googlecode.hotire.springdatajpa.QAccount.account;

import com.googlecode.hotire.springdatajpa.Account;
import com.googlecode.hotire.springdatajpa.QAccount;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class AccountQuerydslRepositorySupport extends QuerydslRepositorySupport {

  public AccountQuerydslRepositorySupport() {
    super(Account.class);
  }
  public List<Account> findByName(String name) {
    return from(QAccount.account).where(account.username.eq(name)).fetch();
  }
}

