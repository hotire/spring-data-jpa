package org.springframework.data.repository.core.support;

import static org.mockito.Mockito.mock;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

class RepositoryFactorySupportTest {

    @Test
    void getTargetRepository() {
        // given
        final EntityManager entityManager = mock(EntityManager.class);
        final RepositoryFactorySupport support = new JpaRepositoryFactory(entityManager);

        // when
//        support.getTargetRepository()
    }
}
