package com.googlecode.hotire.springdatajpa.core.projection;

import javax.persistence.Query;
import org.springframework.data.jpa.repository.query.JpaParametersParameterAccessor;
import org.springframework.data.jpa.repository.query.PartTreeJpaQuery;

/**
 * @see PartTreeJpaQuery
 */
public class PartTreeJpaQueryCoreWithProjection {


    /**
     * @see PartTreeJpaQuery.QueryPreparer
     */
    private class QueryPreparer {


        /**
         * @see PartTreeJpaQuery.QueryPreparer#createCreator(JpaParametersParameterAccessor)
         */
        public Query createQuery(JpaParametersParameterAccessor accessor) {
            return null;
        }
    }

}
