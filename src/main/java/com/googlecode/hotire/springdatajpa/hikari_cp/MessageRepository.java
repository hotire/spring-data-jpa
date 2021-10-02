package com.googlecode.hotire.springdatajpa.hikari_cp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
