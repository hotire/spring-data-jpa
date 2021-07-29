package com.googlecode.hotire.springdatajpa.ex;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudyRepository extends JpaRepository<Study, Long> {
  Optional<Study> findByName(String name);

  @Query("select s from Study s join fetch s.owner")
  Set<Study> findAllJoinFetch();

  @Query("select s from Study s left outer join Account a on s.owner.id = a.id")
  Set<Study> findAllJoinLeft();

  List<StudyMapping> findAllBy();
}
