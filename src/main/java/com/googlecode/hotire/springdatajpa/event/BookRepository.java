package com.googlecode.hotire.springdatajpa.event;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAge(Integer age);
}
