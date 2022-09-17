package com.googlecode.hotire.springdatajpa.save;

import org.springframework.data.domain.Persistable;


/**
 * @see Persistable
 * @see org.springframework.data.jpa.repository.support.JpaPersistableEntityInformation
 */
public interface PersistableCore {

  /**
   * @see org.springframework.data.jpa.repository.support.JpaPersistableEntityInformation#isNew(Persistable) 
   */
  boolean isNew();
}
