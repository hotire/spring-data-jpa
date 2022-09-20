package com.googlecode.hotire.springdatajpa.save;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityExistsException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

@DataJpaTest
class PersistableCoreEntityRepositoryTest {

  @Autowired
  private PersistableCoreEntityRepository repository;

  @Test
  void test() {
    repository.saveAndFlush(new PersistableCoreEntity(1L));
    try {
      repository.saveAndFlush(new PersistableCoreEntity(1L));
    } catch (DataIntegrityViolationException e) {
      if (e.contains(EntityExistsException.class)) {
        e.printStackTrace();
      }
    }
  }
}