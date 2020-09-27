package com.googlecode.hotire.springdatajpa;

import static org.assertj.core.api.Java6Assertions.assertThat;

import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.googlecode.hotire.springdatajpa.n_p.AccountRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class AccountTest {

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private EntityManager entityManager;

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
    Account account3 = new Account();
    account3.setUsername("hotire");
    account3.setAge(1);
    accountRepository.saveAndFlush(account3);
    System.out.println(accountRepository.findAll().size());
  }

  @Test
  void find() {
    Account result = accountRepository.findById(1L).orElseThrow();
    System.out.println(result.getStudies());
  }

  @Test
  void findAll() {
    List<Account> accounts = accountRepository.findAll();
    System.out.println("accounts size : " + accounts.size());
    accounts.forEach(account -> System.out.println("study : " + account.getStudies().size()));
  }

  @Test
  void findAllJoinFetch(){
    Set<Account> accounts = accountRepository.findAllJoinFetch();
    System.out.println("accounts size : " + accounts.size());
    accounts.forEach(account -> System.out.println(account.getStudies()));
  }

  @Test
  void findAllJoinLeft() {
    List<Account> accounts = accountRepository.findAllJoinLeft();
    System.out.println("accounts size : " + accounts.size());
    accounts.forEach(account -> System.out.println(account.getStudies()));
  }

  @Test
  void findAllEntityGraph(){
    List<Account> accounts = accountRepository.findAllEntityGraph();
    accounts.forEach(account -> System.out.println(account.getStudies()));
  }

  @Test
  void bulk() {
    final String qlString = "update Account a "
        + "set a.age = a.age + 1"
        + "where a.username = :username";

    entityManager.createQuery(qlString)
        .setParameter("username", "hotire")
        .executeUpdate();
  }

  @DisplayName("bulk 연산은 데이터베이스에 직접 접근하여 entityManager, 영속성 컨텍스트를 무시한다.")
  @Test
  void dirtyReadByBulk() {
    final List<Account> accounts = entityManager.createQuery("select a from Account a where a.username = :name", Account.class)
        .setParameter("name", "hotire")
        .getResultList();

    accounts.forEach(account -> assertThat(account.getAge()).isEqualTo(1));

    bulk();

    accounts.forEach(account -> assertThat(account.getAge()).isEqualTo(1));
  }

  @Test
  void nativeQuery() {
    final String sql = "SELECT ID, USERNAME, PASSWORD, AGE, HOME_CITY, HOME_STATE, OFFICE_CITY, OFFICE_STATE FROM Account";

    final Query nativeQuery = entityManager.createNativeQuery(sql, Account.class);

    final List<Account> accounts = nativeQuery.getResultList();
  }
}