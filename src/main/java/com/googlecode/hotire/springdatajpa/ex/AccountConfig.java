package com.googlecode.hotire.springdatajpa.ex;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

import com.googlecode.hotire.springdatajpa.n_p.AccountRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class AccountConfig implements InitializingBean {
  private final AccountRepository accountRepository;

  @Override
  public void afterPropertiesSet() throws Exception {
    final Account account = new Account();
    account.setUsername("hello");
    account.setPassword("1234");
//    accountRepository.save(account);
  }
}
