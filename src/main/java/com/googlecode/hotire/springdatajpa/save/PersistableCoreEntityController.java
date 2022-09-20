package com.googlecode.hotire.springdatajpa.save;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PersistableCoreEntityController {

  private final PersistableCoreEntityRepository repository;

  @GetMapping("/persistable/{id}")
  void save(@PathVariable Long id) {
    repository.save(new PersistableCoreEntity(id));
  }

}
