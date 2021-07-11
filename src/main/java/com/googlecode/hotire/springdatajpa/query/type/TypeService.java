package com.googlecode.hotire.springdatajpa.query.type;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
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
        typeRepository.saveAll(List.of(Type.builder().owner(Owner.builder().name("a").build()).build(), Type.builder().owner(Owner.builder().name("a").build()).build()));
        typeRepository.flush();
    }

    public List<Type> findByOwnerName(String ownerName) {
        TypedQuery<Type> query = entityManager.createQuery(
                "SELECT t FROM Type t WHERE t.owner.name = '" + ownerName + "'", Type.class);
        return query.getResultList();
    }

    public List<Type> findByOwnerNameWithPrepared(String ownerName) {
        TypedQuery<Type> query = entityManager.createQuery(
                "SELECT t FROM Type t WHERE t.owner.name = ?1", Type.class);
        query.setParameter(1, ownerName);
        return query.getResultList();
    }

    public List<Type> findByOwnerNameAndIdByCb(Long id, String ownerName) {
        final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Type> query = builder.createQuery(Type.class);
        final Root<Type> root = query.from(Type.class);
        query.select(root).where(
                builder.and(
                        builder.equal(root.get(TypeSpecs.ID.getProperty()), id),
                        builder.equal(root.get(TypeSpecs.OWNER.getProperty()).get(OwnerSpecs.NAME.getProperty()), ownerName
                )
        ));

        TypedQuery<Type> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }

    public List<Type> findByOwnerNameAndIdByCbWithParam(Long id, String ownerName) {
        final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Type> query = builder.createQuery(Type.class);
        final Root<Type> root = query.from(Type.class);
        ParameterExpression<String> paramOwner = builder.parameter(String.class);
        ParameterExpression<Long> paramId = builder.parameter(Long.class);
        query.select(root).where(
                builder.and(
                        builder.equal(root.get(TypeSpecs.ID.getProperty()), paramId),
                        builder.equal(root.get(TypeSpecs.OWNER.getProperty()).get(OwnerSpecs.NAME.getProperty()), paramOwner
                )
                )
        );

        TypedQuery<Type> typedQuery = entityManager.createQuery(query);
        typedQuery.setParameter(paramId, id);
        typedQuery.setParameter(paramOwner, ownerName);
        return typedQuery.getResultList();
    }


    /**
     * criteriaBuilder
     */
    public List<Type> findAll(List<Type> types) {
        final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Type> query = builder.createQuery(Type.class);
        final Root<Type> root = query.from(Type.class);

        final Predicate where = builder.or(types.stream()
                                                .map(it -> builder.and(
                                                        builder.equal(root.get(TypeSpecs.ID.getProperty()), it.getId()),
                                                        builder.equal(root.get(TypeSpecs.OWNER.getProperty()).get(OwnerSpecs.NAME.getProperty()), it.getOwner().getName())
                                                     )
                                                )
                                                .toArray(Predicate[]::new));

        final TypedQuery<Type> typedQuery = entityManager.createQuery(query.select(root).where(where));

        return typedQuery.getResultList();
    }
}
