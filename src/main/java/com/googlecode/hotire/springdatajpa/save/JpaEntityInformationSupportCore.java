package com.googlecode.hotire.springdatajpa.save;

import javax.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.JpaMetamodelEntityInformation;
import org.springframework.data.jpa.repository.support.JpaPersistableEntityInformation;

/**
 * @see JpaEntityInformation
 * @see JpaEntityInformationSupport
 * @see JpaMetamodelEntityInformation
 * @see JpaPersistableEntityInformation
 */
public class JpaEntityInformationSupportCore {

  /**
   * @see JpaEntityInformationSupport#getEntityInformation(Class, EntityManager) 
   */
  public static <T> JpaEntityInformation<T, ?> getEntityInformation(Class<T> domainClass, EntityManager em) {
    return null;
  }
}
