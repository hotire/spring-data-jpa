package com.googlecode.hotire.springdatajpa;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class AccountConfig implements InitializingBean {
  private final AccountRepository accountRepository;

  @Override
  public void afterPropertiesSet() throws Exception {
    Account account = new Account();
    account.setUsername("hello");
    account.setPassword("1234");
    accountRepository.save(account);
  }
}
