package com.googlecode.hotire.springdatajpa;

import static javax.persistence.PersistenceContextType.EXTENDED;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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



    System.out.println(account);
    System.out.println(account);
//    if (1==1)throw new RuntimeException("");

    System.out.println("");

//    entityManager.close();
  }
}
