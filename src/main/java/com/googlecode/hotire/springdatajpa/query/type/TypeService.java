package com.googlecode.hotire.springdatajpa.query.type;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TypeService {
    private final EntityManager entityManager;
    private final TypeRepository typeRepository;

    @PostConstruct
    public void init() {
        typeRepository.saveAll(List.of(Type.builder().name("a").build(), Type.builder().name("b").build()));
        typeRepository.flush();
    }

    public List<Type> findAll(List<Type> types) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Type> query = builder.createQuery(Type.class);
        Root<Type> root = query.from(Type.class);

        final Predicate where = builder.or(types.stream()
                                                .map(it -> builder.and(builder.equal(root.get("name"), it.getName()), builder.equal(root.get("id"), it.getId())))
                                                .toArray(Predicate[]::new));

        final TypedQuery<Type> typedQuery = entityManager.createQuery(query.select(root).where(where));

        return typedQuery.getResultList();
    }
}