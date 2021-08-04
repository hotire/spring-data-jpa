# N+1


## Cartasian product

### EntityGraph

### QueryTranslator

### org.hibernate.hql.internal.ast.QueryTranslatorImpl

- list

~~~java
		final boolean needsDistincting = (
				query.getSelectClause().isDistinct() ||
				getEntityGraphQueryHint() != null ||
				hasLimit )
		&& containsCollectionFetches();
~~~