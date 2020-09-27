package com.googlecode.hotire.springdatajpa;

import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;

import com.googlecode.hotire.springdatajpa.n_p.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudyRepositoryTest {

  @Autowired
  private StudyRepository studyRepository;

  @Autowired
  private AccountRepository accountRepository;

  @PostConstruct
  public void config () {
    Account account = new Account();
    account.addStudy(Study.createInstance("hello"));
    account.addStudy(Study.createInstance("hello2"));
    account.addStudy(Study.createInstance("hello3"));
    accountRepository.saveAndFlush(account);
    Account account2 = new Account();
    account2.addStudy(Study.createInstance("hello4"));
    account2.addStudy(Study.createInstance("hello5"));
    account2.addStudy(Study.createInstance("hello6"));
    accountRepository.saveAndFlush(account2);
    System.out.println(accountRepository.findAll().size());
  }

  @Test
  public void findAll() {
    List<Study> studies = studyRepository.findAll();
  }

  @Test
  public void findAllJoinFetch() {
    Set<Study> studies = studyRepository.findAllJoinFetch();
    studies.forEach(study -> System.out.println(study.getOwner()));
  }

  @Test
  public void findAllBy() {
    List<StudyMapping> studies = studyRepository.findAllBy();
    studies.forEach(study -> System.out.println(study.getOwner()));
  }

  @Test
  public void findAllJoinLeft() {
    Set<Study> studies = studyRepository.findAllJoinLeft();
    studies.forEach(study -> System.out.println(study.getOwner()));
  }
}