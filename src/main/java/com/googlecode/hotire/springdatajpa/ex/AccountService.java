package com.googlecode.hotire.springdatajpa.ex;

import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.hotire.springdatajpa.n_p.AccountRepository;

/**
 * EntityManager Life Cycle Test
 *
 */
//@Transactional
@Service
public class AccountService {
  @Autowired
  private AccountRepository accountRepository;
//  @PersistenceContext(type = EXTENDED)
  @PersistenceContext()
  private EntityManager entityManager;

  @Transactional
  public void test() {
    System.out.println(entityManager);
    Account account = entityManager.find(Account.class, 1L);
    account = entityManager.find(Account.class, 1L);
    account = entityManager.find(Account.class, 1L);

//    if (1==1)throw new RuntimeException("");

    System.out.println("");

//    entityManager.close();
  }

  public Account save(final Account account) {
    return accountRepository.save(account);
  }

  public List<Account> list() {
    return accountRepository.findAll();
  }

  public List<Account> findAllJoinFetch() {
    return accountRepository.findAllJoinLeft();
  }

  @Transactional
  public void service(final Consumer<Account> accountConsumer, final Account account) {
    accountConsumer.accept(account);
  }
}
