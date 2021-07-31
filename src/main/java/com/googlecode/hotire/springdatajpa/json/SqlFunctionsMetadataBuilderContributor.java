package com.googlecode.hotire.springdatajpa.json;

import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.spi.MetadataBuilderContributor;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

/**
 * @see org.hibernate.jpa.boot.internal.SpringHibernateJpaPersistenceProvider#createContainerEntityManagerFactory
 * @see org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl#applyMetadataBuilderContributor
 */
public class SqlFunctionsMetadataBuilderContributor implements MetadataBuilderContributor {
    @Override
    public void contribute(final MetadataBuilder metadataBuilder) {
        metadataBuilder.applySqlFunction("JSON_CONTAINS", new StandardSQLFunction("JSON_CONTAINS", StandardBasicTypes.BOOLEAN));
    }
}
