package com.googlecode.hotire.springdatajpa.ex;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

  @Autowired
  private AccountService accountService;

  @PersistenceContext()
//  @PersistenceContext()
  private EntityManager entityManager;

  @GetMapping("/entity")
  public ResponseEntity<Account> getEntityManager() {
    System.out.println(entityManager);
    entityManager.clear();
    accountService.test();
    return ResponseEntity.ok().build();
  }


  @GetMapping("/list")
  public ResponseEntity<List<Account>> list() {
    return ResponseEntity.ok().body(accountService.list());
  }

  @GetMapping("/save")
  public ResponseEntity<Account> getEntityManager2(@RequestParam final boolean isThrow) {
    final Account account = new Account();
    account.setUsername("hello");
    account.setPassword("1234");
    accountService.service(account1 -> {
      accountService.save(account1);
      if (isThrow) {
        throw new RuntimeException("abc");
      }
    }, account);
    return ResponseEntity.ok().build();
  }
}
