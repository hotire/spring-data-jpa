# Method

## CRUD

RepositoryFactorySupport 에서 getRepository 시 QueryExecutorMethodInterceptor advice건다.

- getQueryLookupStrategy
    - 구현체 JpaRepositoryFactory 사용 

### QueryExecutorMethodInterceptor
- Map<Method, RepositoryQuery>
- lookupQuery

### QueryLookupStrategy

- Key 기본전략은 CREATE_IF_NOT_FOUND 으로 CreateIfNotFoundQueryLookupStrategy 사용된다.
  - Key 설정은 DefaultRepositoryConfiguration / AnnotationRepositoryConfigurationSource

### CreateIfNotFoundQueryLookupStrategy

- lookupStrategy 
- createStrategy : PartTreeJpaQuery 생성 

### PartTreeJpaQuery


## RepositoryInformation

- getQueryMethods()


## JpaQueryLookupStrategy.AbstractQueryLookupStrategy

- resolveQuery : JpaQueryMethod 생성

- resolveQuery(JpaQueryMethod) : RepositoryQuery로 생성 


### SimpleJpaQuery : AbstractStringBasedJpaQuery : AbstractJpaQuery: RepositoryQuery

내부적으로 Query 를 사용하게 됨. 

