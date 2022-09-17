package com.googlecode.hotire.springdatajpa.save;

import javax.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;

/**
 * @see JpaEntityInformationSupport
 */
public class JpaEntityInformationSupportCore {

  /**
   * @see JpaEntityInformationSupport#getEntityInformation(Class, EntityManager) 
   */
  public static <T> JpaEntityInformation<T, ?> getEntityInformation(Class<T> domainClass, EntityManager em) {
    return null;
  }
}
