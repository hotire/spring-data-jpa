# Method

## CRUD

RepositoryFactorySupport 에서 getRepository 시 QueryExecutorMethodInterceptor advice건다.

### QueryExecutorMethodInterceptor

Map<Method, RepositoryQuery>

## RepositoryInformation

- getQueryMethods()


## JpaQueryLookupStrategy.AbstractQueryLookupStrategy

- resolveQuery : JpaQueryMethod 생성

- resolveQuery(JpaQueryMethod) : RepositoryQuery로 생성 


### SimpleJpaQuery : AbstractStringBasedJpaQuery : AbstractJpaQuery: RepositoryQuery

내부적으로 Query 를 사용하게 됨. 
