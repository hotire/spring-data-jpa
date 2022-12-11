# Transaction

## Propagation

트랜잭션 전파 전략을 설정할 수 있다. 

또한 롤백에 대한 전략도 설정할 수 있다. 

- no-rollback-for : 롤백하지 않을 익셉션 타입
- rollback-for : 롤백할 익셉션 타입

### Propagation.REQUIRED

- default 

부모 트랜잭션 내에서 실행하며, 부모 트랜잭션이 없을 경우 새로운 트랜잭션 생성
호출한 곳에서 이미 트랜잭션이 설정되어 있다면 기존의 트랜잭션 내에서 로직을 실행한다.

### Propagation.REQUIRES_NEW

매번 새로운 트랜잭션을 시작한다. 

### Propagation.NESTED

부모 트랜잭션과 별개로 커밋, 롤백이 가능하다. 

DB 지원이 필요한데 ORACLE만 가능하다.

### Propagation.MANDATORY

부모 트랜잭션 내에서 실행되며, 부모 트랜잭션이 없을 경우 Exception이 발생한다.

### Propagation.SUPPORT

부모 트랜잭션이 존재하면 부모 트랜잭션으로 동작하고, 없을경우 non-transactional 하게 동작한다.

### Propagation.NOT_SUPPORTED

non-transactional 로 실행되며 부모 트랜잭션이 존재하면 일시 정지한다.

### Propagation.NEVER

non-transactional 로 실행되며 부모 트랜잭션이 존재하면 Exception이 발생한다.



## Isolation

## TransactionManager
org.springframework.transaction.TransactionManager

- PlatformTransactionManager
- ReactiveTransactionManager

### AOP

PointCut : TransactionAttributeSourcePointcut 생성
Advice : TransactionInterceptor 

결합 형태의 Advisor를 생성한다. 

BeanPostProcessor의 구현체 AnnotationAwareAspectJAutoProxyCreator에서 Advisor를 Beanfactory에서 찾아오게된다. 

Advisor는 match로 검사하고 TransactionInterceptor를 Proxy 객체를 interface기반 DynamicProxy, class일 경우 cglib으로 생성한다.




### TransactionInterceptor

AOP 설정에 의해 설정된 TransactionInterceptor가 설정되어 invokeWithTransaction에서 트랜잭션과 함께 메서드가 실행되고 

- completeTransactionAfterThrowing : 

- commitTransactionAfterReturning : 

rollback / commit을 진행한다.


### JpaTransactionManager

PlatformTransactionManager, AbstractPlatformTransactionManager의 구현체

### Summary

- AOP에 의해 TransactionInterceptor 가 AOP로 설정된다.
- TransactionManager에 의해 커밋, 롤백이 실행된다.


// 
- AnnotationAwareAspectJAutoProxyCreator 

- BeanFactoryAspectJAdvisorsBuilder

- ReflectiveAspectJAdvisorFactory : AspectJAdvisorFactory  custom Annotation을 찾아 Advisor구현체를 생성한다. 구현체는 InstantiationModelAwarePointcutAdvisorImpl 사용한다.

- Transaction 의 경우 Advisor 구현체는 BeanFactoryTransactionAttributeSourceAdvisor 를 사용한다. 

  내부적으로 TransactionAttributeSource 구현체 AnnotationTransactionAttributeSource 사용한다. 

  AnnotationTransactionAttributeSource 을 통해 Method @Transaactional 를 찾아 advice 건다.

- DefaultAopProxyFactory 를 통해 AopProxy 생성한다.

- AopProxy 를 통해 Proxy 객체를 생성하게 된다.


### References

- https://cobbybb.tistory.com/25



## Rollback ISSUE

- https://techblog.woowahan.com/2606/


## doBegin && Connection

- JpaTransactionManager 
- HibernateJpaDialect : JpaDialect
  - beginTransaction()
- TransactionImpl : EntityTransaction 
  - begin
- TransactionDriverControlImpl : TransactionDriver
  - begin
- LogicalConnectionManagedImpl : JdbcResourceTransaction
  - begin
  - getConnectionForTransactionManagement
  - getPhysicalConnection
  - acquireConnectionIfNeeded
- NonContextualJdbcConnectionAccess : JdbcConnectionAccess
  - obtainConnection()
- DatasourceConnectionProviderImpl : ConnectionProvider
  - getConnection()
- HikariDataSource : DataSource


## TransactionSynchronization

- TransactionSynchronizationManager.isActualTransactionActive : 트랜잭션 여부 체크
- TransactionAspectSupportCore.currentTransactionStatus : commit 여부 체크로, TransactionSynchronization 안에서 TransactionSynchronization 등록하는걸 확인하기 용도


TransactionSynchronizationManager.clear() 호출시 isActualTransactionActive 초기화된다.
- by AbstractPlatformTransactionManager.cleanupAfterCompletion 에서 호출한다.
- by AbstractPlatformTransactionManager.processRollback or processCommit
- by AbstractPlatformTransactionManager.commit
- by TransactionAspectSupport.commitTransactionAfterReturning






## References

- https://wave1994.tistory.com/178