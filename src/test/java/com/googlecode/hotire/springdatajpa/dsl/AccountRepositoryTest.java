package com.googlecode.hotire.springdatajpa.dsl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.googlecode.hotire.springdatajpa.Account;
import com.googlecode.hotire.springdatajpa.QAccount;
import com.googlecode.hotire.springdatajpa.n_p.AccountRepository;
import com.querydsl.core.types.Predicate;

@DataJpaTest
class AccountRepositoryTest {

  @Autowired
  private AccountRepository accountRepository;

  @Test
  void find() {
    // given
    final Predicate predicate = QAccount.account.username.eq("hotire");

    // when
    final boolean exists = accountRepository.exists(predicate);

    // then
    assertThat(exists).isFalse();
  }

  @Rollback(value = false)
  @Test
  void save() {
    Account account = accountRepository.save(new Account());

    List<Account> result = accountRepository.findAll();

    System.out.println(result);


  }

}
