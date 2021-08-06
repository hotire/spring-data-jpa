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

사용시 getEntityGraphQueryHint() true를 리턴하여 needsDistincting true로 설정된다. 
