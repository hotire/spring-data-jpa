# EntityManager


## HibernateJpaConfiguration

- JpaVendorAdapter bean으로 생성 

JpaVendorAdapter 구현체 중 HibernateJpaVendorAdapter 사용 

HibernateJpaVendorAdapter는 SpringHibernateJpaPersistenceProvider을 사용한다.

## HibernateJpaConfiguration : JpaBaseConfiguration 

EntityManagerFactoryBuilder를 통해 LocalContainerEntityManagerFactoryBean 생성한다.

afterPropertiesSet 에서 createNativeEntityManagerFactory() JpaVendorAdapter를 통해 EntityManagerFactory를 생성한다.


## LocalContainerEntityManagerFactoryBean : AbstractEntityManagerFactoryBean : FactoryBean<EntityManagerFactory>

1. afterPropertiesSet()
2. buildNativeEntityManagerFactory()
3. createNativeEntityManagerFactory()
4. provider.createContainerEntityManagerFactory(this.persistenceUnitInfo, getJpaPropertyMap());

## SpringHibernateJpaPersistenceProvider extends PersistenceProvider

1. createContainerEntityManagerFactory()



## SharedEntityManagerBean : FactoryBean<EntityManager>

## EntityManagerFactory

- SessionFactoryImpl


## Summary

// EntityManagerFactory 생성 과정

1. EntityManagerFactory는 FactoryBean<EntityManagerFactory>(Object 인스턴스를 반환할 수 있는 팩토리) 을 사용한다. 
2. 구현체는 LocalContainerEntityManagerFactoryBean : AbstractEntityManagerFactoryBean 사용한다. 
3. LocalContainerEntityManagerFactoryBean의 afterPropertiesSet 호출시 PersistenceProvider을 통해 EntityManagerFactory을 생성한다.

// PersistenceProvider 과정 

1. HibernateJpaConfiguration에 의해  HibernateJpaVendorAdapter: JpaVendorAdapter을 생성한다. 
2. HibernateJpaVendorAdapter는 SpringHibernateJpaPersistenceProvider: PersistenceProvider을 사용한다. 
3. SpringHibernateJpaPersistenceProvider의 createContainerEntityManagerFactory을 통해 EntityManagerFactory을 생성한다.

// EntityManager

1. EntityManager는 FactoryBean<EntityManager> 사용한다. 
2. 구현체는 SharedEntityManagerBean 사용한다. 
3. afterPropertiesSet 호출시 shared 라는 EntityManager 생성한다.
4. shared 는 proxy 객체로 



## Persist

PersistEvent 를 발행한다. 

Listner는 DefaultPersistEventListener 하나뿐이다.

- entityIsTransient case 이기 떄문에 saveWithGeneratedId 호출한다. 

### DefaultPersistEventListener : AbstractSaveEventListener

saveWithGeneratedId 과정 

- callbackRegistry.preCreate( entity ) : @PrePersist 호출 

- getIdentifierGenerator : POST_INSERT_INDICATOR

- performSave 호출 

- performSaveOrReplicate 호출 

- addInsertAction 호출

- EntityIdentityInsertAction 생성후 ActionQueue에 addAction

### ActionQueue 

- addAction 

- addInsertAction

- executeInserts

- executeActions

- EntityIdentityInsertAction.execute 호출 


### EntityIdentityInsertAction

~~~
generatedId = persister.insert( getState(), instance, session );
~~~



