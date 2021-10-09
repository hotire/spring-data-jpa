# Repository

## RepositoryProxyPostProcessor

- TransactionalRepositoryProxyPostProcessor

~~~
TransactionInterceptor transactionInterceptor = new TransactionInterceptor(null, transactionAttributeSource)...
factory.addAdvice(transactionInterceptor);
~~~


## JpaRepository 

JpaRepository 인터페이스의 경우 아래의 인터페이스를 사용한다. 

### Repository 

### CrudRepository

### PagingAndSortingRepository

### SimpleJpaRepository

구현체의 모습이 SimpleJpaRepository 이다. 

- JpaRepositoryFactory extends RepositoryFactorySupport 의 repositoryBaseClass가 empty로 설정되어서 
- JpaRepositoryFactory.getRepositoryInformation 호출한다. 
- getRepositoryInformation의 리턴은 SimpleJpaRepository 이다.
- RepositoryFactorySupport getTargetRepositoryViaReflection를 통해 SimpleJpaRepository 구현체를 생성한다. 


### JpaRepositoriesAutoConfiguration

### JpaRepositoriesRegistrar extends AbstractRepositoryConfigurationSourceSupport

### AutoConfiguredAnnotationRepositoryConfigurationSource

- getBasePackages()

### RepositoryConfigurationDelegate

- registerRepositoriesIn -> definitions

### RepositoryBeanDefinitionBuilder

- build() -> configuration.getRepositoryFactoryBeanClassName())

### DefaultRepositoryConfiguration

- getRepositoryFactoryBeanClassName

### JpaRepositoryConfigExtension extends RepositoryConfigurationExtension

- getRepositoryFactoryBeanClassName -> JpaRepositoryFactoryBean.class.getName()

- EnableJpaRepositories -> Import(JpaRepositoriesRegistrar)

### JpaRepositoryFactoryBean extends TransactionalRepositoryFactoryBeanSupport

### TransactionalRepositoryFactoryBeanSupport extends RepositoryFactoryBeanSupport

- RepositoryFactoryBeanSupport.afterPropertiesSet()


## RepositoryInformation

### RepositoryFactorySupport

- getRepository()

- getRepositoryInformation()


## RepositoryMetadata

- org.springframework.data.repository.core.support.RepositoryFactorySupport#getRepository(Class, RepositoryFragments) 

## AbstractRepositoryMetadata

- getMetadata 해당 메서드를 통해 Repository의 CRUD... etc 정보를 얻어온다. 

 












