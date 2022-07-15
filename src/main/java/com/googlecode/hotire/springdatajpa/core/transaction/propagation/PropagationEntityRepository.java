package com.googlecode.hotire.springdatajpa.core.transaction.propagation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface PropagationEntityRepository extends JpaRepository<PropagationEntity, Long> {

    @Transactional(propagation = Propagation.NESTED)
    default PropagationEntity saveWithNested(final PropagationEntity entity) {
        return save(entity);
    }

}
