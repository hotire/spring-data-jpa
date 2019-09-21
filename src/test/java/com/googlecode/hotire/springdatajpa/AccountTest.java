package com.googlecode.hotire.springdatajpa;

import javax.annotation.PostConstruct;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountTest{

  @Autowired
  private AccountRepository accountRepository;

  @PostConstruct
  public void config () {
    Account account = new Account();
    account.addStudy(Study.getInstance("hello"));
    account.addStudy(Study.getInstance("hello2"));
    account.addStudy(Study.getInstance("hello3"));
    accountRepository.saveAndFlush(account);
    Account account2 = new Account();
    account.addStudy(Study.getInstance("hello4"));
    account.addStudy(Study.getInstance("hello5"));
    account.addStudy(Study.getInstance("hello6"));
    accountRepository.saveAndFlush(account2);
  }

  @Test
  public void find() {
    Account result = accountRepository.findById(1L).orElseThrow();
    System.out.println(result.getStudies());

  }

  @Test
  public void findAll(){
    accountRepository.findAll();
  }
}