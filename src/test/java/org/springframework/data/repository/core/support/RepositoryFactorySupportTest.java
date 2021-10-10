package org.springframework.data.repository.core.support;

import static org.mockito.Mockito.mock;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryComposition.RepositoryFragments;
import org.springframework.util.Assert;

import lombok.Data;

class RepositoryFactorySupportTest {

    @Data
    static class Entity {
        private Long id;
    }

    interface CustomRepository extends Repository<Entity, Long> {
    }

    @DisplayName("Learn internal RepositoryFactorySupport#getTargetRepository")
    @Test
    void getTargetRepository() {
        // given
        final EntityManager entityManager = mock(EntityManager.class);
        final RepositoryFactorySupport support = new JpaRepositoryFactory(entityManager);

        final RepositoryMetadata metadata = AbstractRepositoryMetadata.getMetadata(CustomRepository.class);
        final RepositoryFragments fragments = RepositoryFragments.empty();
        final RepositoryComposition composition = getRepositoryComposition(support, metadata, fragments);
        final RepositoryInformation information = getRepositoryInformation(metadata, composition);

        // when
        final JpaRepositoryImplementation<?, ?>  repository = (JpaRepositoryImplementation<?, ?>) support.getTargetRepository(information);

        // no assert
    }

    private RepositoryInformation getRepositoryInformation(final RepositoryMetadata metadata,
                                                           final RepositoryComposition composition) {

        final Class<?> baseClass = SimpleJpaRepository.class;
        return new DefaultRepositoryInformation(metadata, baseClass, composition);
    }

    private RepositoryComposition getRepositoryComposition(final RepositoryFactorySupport support, final RepositoryMetadata metadata, final RepositoryFragments fragments) {

        Assert.notNull(metadata, "RepositoryMetadata must not be null!");
        Assert.notNull(fragments, "RepositoryFragments must not be null!");

        final RepositoryComposition composition = getRepositoryComposition(metadata);
        final RepositoryFragments repositoryAspects = support.getRepositoryFragments(metadata);

        return composition.append(fragments).append(repositoryAspects);
    }

    private RepositoryComposition getRepositoryComposition(final RepositoryMetadata metadata) {

        final RepositoryComposition composition = RepositoryComposition.empty();

        if (metadata.isReactiveRepository()) {
            return composition.withMethodLookup(MethodLookups.forReactiveTypes(metadata));
//                              .withArgumentConverter(REACTIVE_ARGS_CONVERTER);
        }

        return composition.withMethodLookup(MethodLookups.forRepositoryTypes(metadata));
    }

}
