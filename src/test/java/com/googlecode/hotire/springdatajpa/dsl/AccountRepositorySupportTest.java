package com.googlecode.hotire.springdatajpa.dsl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.googlecode.hotire.springdatajpa.ex.Account;
import com.googlecode.hotire.springdatajpa.ex.Study;
import com.googlecode.hotire.springdatajpa.n_p.AccountRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositorySupportTest {

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private EntityManager entityManager;

  @Before
  public void config() {
    accountRepository.saveAndFlush(new Account("hotire").addStudy(new Study()).addStudy(new Study()));
    accountRepository.saveAndFlush(new Account("hotire").addStudy(new Study()).addStudy(new Study()));
    accountRepository.saveAndFlush(new Account("atire"));
    accountRepository.saveAndFlush(new Account("btire"));
    entityManager.clear();
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

  @Test
  public void findByUsername() {
    // Given
    final String name = "hotire";

    // When
    final List<Account> accounts = accountRepository.findByUsername(name);

    // Then
    assertThat(accounts.size()).isEqualTo(2);
  }

  @Test
  public void findByName2() {
    // Given
    final String name = "hotire";

    // When
    final List<Account> accounts = accountRepository.findByName2(name);

    // Then
    assertThat(accounts.size()).isEqualTo(2);
  }
}