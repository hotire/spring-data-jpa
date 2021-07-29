package com.googlecode.hotire.springdatajpa.dsl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.googlecode.hotire.springdatajpa.ex.Account;
import com.googlecode.hotire.springdatajpa.n_p.AccountRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountQuerydslRepositorySupportTest {

  @Autowired
  private AccountQuerydslRepositorySupport accountQuerydslRepositorySupport;

  @Autowired
  private AccountRepository accountRepository;

  @Before
  public void config() {
    accountRepository.save(new Account("hotire"));
    accountRepository.save(new Account("hotire"));
    accountRepository.save(new Account("atire"));
    accountRepository.save(new Account("btire"));
  }

  @Test
  public void findByName() {
    // When
    final List<Account> accounts =  accountQuerydslRepositorySupport.findByName("hotire");

    // Then
    assertThat(accounts.size()).isEqualTo(2);
  }
}