package com.googlecode.hotire.springdatajpa.hikari_cp;

import com.zaxxer.hikari.HikariDataSource;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @see com.zaxxer.hikari.HikariDataSource
 */
@RequiredArgsConstructor
public class HikariDataSourceDecorator {
    @Getter(AccessLevel.PROTECTED)
    private final HikariDataSource dataSource;
}
