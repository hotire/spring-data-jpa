# Repository

## RepositoryProxyPostProcessor

- TransactionalRepositoryProxyPostProcessor

~~~
TransactionInterceptor transactionInterceptor = new TransactionInterceptor(null, transactionAttributeSource)...
factory.addAdvice(transactionInterceptor);
~~~


## JpaRepository

### Repository

### CrudRepository

### PagingAndSortingRepository

### SimpleJpaRepository


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

 












