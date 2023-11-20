package com.googlecode.hotire.springdatajpa.cursor;

import java.util.stream.Stream;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursorRepository extends JpaRepository<Cursor, Long> {
    Stream<Cursor> streamAllBy();
    Stream<Cursor> streamAllByOrderById();
}
