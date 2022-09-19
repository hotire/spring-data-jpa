package com.googlecode.hotire.springdatajpa.save;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class PersistableCoreEntity implements Persistable<Long> {

  @Id
  @Column(name = "id", nullable = false)
  private Long id;

  public Long getId() {
    return id;
  }

  @Override
  public boolean isNew() {
    return true;
  }

  public void setId(Long id) {
    this.id = id;
  }

}
