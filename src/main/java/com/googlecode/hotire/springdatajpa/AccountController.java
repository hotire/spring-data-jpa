package com.googlecode.hotire.springdatajpa;

import static javax.persistence.PersistenceContextType.EXTENDED;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

  @Autowired
  private AccountService accountService;

  @PersistenceContext()
//  @PersistenceContext()
  private EntityManager entityManager;

  @GetMapping("/entity")
  public ResponseEntity getEntityManager() {
    System.out.println(entityManager);
    entityManager.clear();
    accountService.test();
    return ResponseEntity.ok().build();
  }
}
