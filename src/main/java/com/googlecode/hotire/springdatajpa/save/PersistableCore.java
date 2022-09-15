package com.googlecode.hotire.springdatajpa.save;

import org.springframework.data.domain.Persistable;


/**
 * @see Persistable
 */
public interface PersistableCore {

  /**
   * @see org.springframework.data.jpa.repository.support.JpaPersistableEntityInformation#isNew(Persistable) 
   */
  boolean isNew();
}
