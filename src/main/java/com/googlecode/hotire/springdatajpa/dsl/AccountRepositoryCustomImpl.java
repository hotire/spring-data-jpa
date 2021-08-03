package com.googlecode.hotire.springdatajpa.dsl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.googlecode.hotire.springdatajpa.ex.Account;
import com.googlecode.hotire.springdatajpa.ex.QAccount;
import com.googlecode.hotire.springdatajpa.ex.QStudy;

public class AccountRepositoryCustomImpl extends QuerydslRepositorySupport implements
  AccountRepositoryCustom {

  public AccountRepositoryCustomImpl() {
    super(Account.class);
  }

  @Override
  public List<Account> findByName(final String name) {
    return from(QAccount.account)
            .leftJoin(QAccount.account.studies, QStudy.study)
            .where(QAccount.account.username.eq(name)).fetch();
  }

  @Override
  public List<Account> findByName2(final String name) {
    final CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
    final CriteriaQuery<Account> query = builder.createQuery(Account.class);
    final Root<Account> root = query.from(Account.class);
    root.fetch("studies", JoinType.LEFT);
    query.select(root).distinct(true).where(builder.equal(root.get("username"), name));

    final TypedQuery<Account> typedQuery = getEntityManager().createQuery(query);
    return typedQuery.getResultList();
  }

}
