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
- RepositoryFactorySupport getTargetRepositoryViaReflection 를 통해 SimpleJpaRepository 구현체를 생성한다. 


### JpaRepositoriesAutoConfiguration

### JpaRepositoriesRegistrar extends AbstractRepositoryConfigurationSourceSupport

: RepositoryConfigurationDelegate 에게 처리를 위임한다. 

- registerBeanDefinitions

### AutoConfiguredAnnotationRepositoryConfigurationSource

: AbstractRepositoryConfigurationSourceSupport 내부에 있는 클래스로 getBasePackages에 주요 역할을 한다. 

- spring-core / boot
https://github.com/hotire/spring-core/tree/master/service/src/main/java/com/github/hotire/springcore/boot
- getBasePackages()

~~~java
protected Streamable<String> getBasePackages() {
		return Streamable.of(AutoConfigurationPackages.get(this.beanFactory));
}
~~~

### RepositoryConfigurationDelegate

1. getBasePackages 중 repository를 scan 한다.
2. RepositoryBeanDefinitionBuilder를 통해 JpaRepositoryFactoryBean 생성한다.

- registerRepositoriesIn -> definitions

### RepositoryBeanDefinitionBuilder

- build() -> configuration.getRepositoryFactoryBeanClassName())

### DefaultRepositoryConfiguration

- getRepositoryFactoryBeanClassName

### JpaRepositoryConfigExtension extends RepositoryConfigurationExtension

- getRepositoryConfigurations : scan package repository 

- configSource.getCandidates(loader) 
- RepositoryConfigurationSourceSupport.getCandidates
- AutoConfiguredAnnotationRepositoryConfigurationSource#getBasePackages
- getRepositoryFactoryBeanClassName -> JpaRepositoryFactoryBean.class.getName()

- EnableJpaRepositories -> Import(JpaRepositoriesRegistrar)

### JpaRepositoryFactoryBean extends TransactionalRepositoryFactoryBeanSupport

1. afterPropertiesSet 호출
2. repository 를 factory를 통해 Lazy로 생성한다. 
3. factory는 RepositoryFactorySupport 이다. 

### TransactionalRepositoryFactoryBeanSupport extends RepositoryFactoryBeanSupport

- RepositoryFactoryBeanSupport.afterPropertiesSet()

## RepositoryInformation

### RepositoryFactorySupport

구현체는 JpaRepositoryFactory를 사용한다. 

RepositoryFactorySupport는 실제 Repository를 생성한다.

- getRepository()

- getRepositoryInformation()


## RepositoryMetadata

- org.springframework.data.repository.core.support.RepositoryFactorySupport#getRepository(Class, RepositoryFragments) 

## AbstractRepositoryMetadata

- getMetadata 해당 메서드를 통해 Repository의 CRUD... etc 정보를 얻어온다. 

 
### ETC

- AnnotationRepositoryConfigurationSource#getBasePackages extends RepositoryConfigurationSourceSupport 


## Summary

1. JpaRepositoriesAutoConfiguration autoConfig에 의해 JpaRepositoriesRegistrar Import 된다.
2. JpaRepositoriesRegistrar RepositoryConfigurationDelegate에게 처리를 위임한다.  
(AutoConfiguredAnnotationRepositoryConfigurationSource) 도 생성
3. RepositoryConfigurationDelegate는 package scan (reposiotry)
4. RepositoryBeanDefinitionBuilder를 통해 RepositoryBeanDefinition 생성 (JpaRepositoryFactoryBean)
5. JpaRepositoryFactoryBean afterPropertiesSet시 repository 를 factory를 통해 Lazy로 생성한다. 
6. factory는 JpaRepositoryFactory : RepositoryFactorySupport 이다. 
7. 생성할떄 여러 meta information 정보가 필요한데 이떄 SimpleJpaRepository를 얻어온다.








