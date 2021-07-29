package com.googlecode.hotire.springdatajpa;

import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.googlecode.hotire.springdatajpa.ex.Account;
import com.googlecode.hotire.springdatajpa.ex.Study;
import com.googlecode.hotire.springdatajpa.ex.StudyMapping;
import com.googlecode.hotire.springdatajpa.ex.StudyRepository;
import com.googlecode.hotire.springdatajpa.n_p.AccountRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudyRepositoryTest {

  @Autowired
  private StudyRepository studyRepository;

  @Autowired
  private AccountRepository accountRepository;

  @PostConstruct
  public void config () {
    final Account account = new Account();
    account.addStudy(Study.createInstance("hello"));
    account.addStudy(Study.createInstance("hello2"));
    account.addStudy(Study.createInstance("hello3"));
    accountRepository.saveAndFlush(account);
    final Account account2 = new Account();
    account2.addStudy(Study.createInstance("hello4"));
    account2.addStudy(Study.createInstance("hello5"));
    account2.addStudy(Study.createInstance("hello6"));
    accountRepository.saveAndFlush(account2);
    System.out.println(accountRepository.findAll().size());
  }

  @Test
  public void findAll() {
    final List<Study> studies = studyRepository.findAll();
  }

  @Test
  public void findAllJoinFetch() {
    final Set<Study> studies = studyRepository.findAllJoinFetch();
    studies.forEach(study -> System.out.println(study.getOwner()));
  }

  @Test
  public void findAllBy() {
    final List<StudyMapping> studies = studyRepository.findAllBy();
    studies.forEach(study -> System.out.println(study.getOwner()));
  }

  @Test
  public void findAllJoinLeft() {
    final Set<Study> studies = studyRepository.findAllJoinLeft();
    studies.forEach(study -> System.out.println(study.getOwner()));
  }
}