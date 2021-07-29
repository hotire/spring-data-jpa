package com.googlecode.hotire.springdatajpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.googlecode.hotire.springdatajpa.ex.Account;
import com.googlecode.hotire.springdatajpa.ex.Study;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MappingTest {

  @PersistenceContext
  private EntityManager entityManager;

  @Test
  public void save() throws InterruptedException {
    final Account account = new Account();
    account.setUsername("hotire");
    account.setPassword("1234");

    final Study study = new Study();
    study.setName("Spring Data Jpa");

    account.addStudy(study);

    final Session session = entityManager.unwrap(Session.class);
    session.save(study);
    session.save(account);
    session.flush();
  }

}
