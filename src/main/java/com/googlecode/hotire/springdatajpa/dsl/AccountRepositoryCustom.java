package com.googlecode.hotire.springdatajpa.dsl;

import java.util.List;

import com.googlecode.hotire.springdatajpa.Account;

public interface AccountRepositoryCustom {
  List<Account> findByName(String name);
}
