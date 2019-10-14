package com.googlecode.hotire.springdatajpa.dsl;

import com.googlecode.hotire.springdatajpa.Account;
import java.util.List;

public interface AccountRepositoryCustom {
  List<Account> findByName(String name);
}
