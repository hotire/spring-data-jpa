package com.googlecode.hotire.springdatajpa.core.repository;

import com.googlecode.hotire.springdatajpa.core.Core;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

/**
 * @see QueryByExampleExecutor
 * @see SimpleJpaRepository
 */
public class SimpleJpaRepositoryCore implements JpaRepository<Core, Long> {

    @Override
    public List<Core> findAll() {
        return null;
    }

    @Override
    public List<Core> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Core> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Core> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Core entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends Core> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Core> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Core> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Core> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Core> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Core> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Core getOne(Long aLong) {
        return null;
    }

    /**
     * @see QueryByExampleExecutor#findOne(Example) 
     * @see SimpleJpaRepository#findOne(Example)
     */
    @Override
    public <S extends Core> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Core> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Core> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Core> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Core> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Core> boolean exists(Example<S> example) {
        return false;
    }
}
