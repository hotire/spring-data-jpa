package com.googlecode.hotire.springdatajpa.dsl;

import static org.assertj.core.api.Assertions.assertThat;

import com.googlecode.hotire.springdatajpa.Account;
import com.googlecode.hotire.springdatajpa.AccountRepository;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositorySupportTest {

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
    // Given
    final String name = "hotire";

    // When
    final List<Account> accounts = accountRepository.findByName(name);

    // Then
    assertThat(accounts.size()).isEqualTo(2);
  }
}