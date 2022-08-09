# Core

## Config

### HibernateJpaAutoConfiguration

org.springframework.boot.autoconfigure.EnableAutoConfiguration 

### HibernateJpaConfiguration extends JpaBaseConfiguration 

~~~java
	@Bean
	@Primary
	@ConditionalOnMissingBean({ LocalContainerEntityManagerFactoryBean.class, EntityManagerFactory.class })
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder factoryBuilder) {
		Map<String, Object> vendorProperties = getVendorProperties();
		customizeVendorProperties(vendorProperties);
		return factoryBuilder.dataSource(this.dataSource).packages(getPackagesToScan()).properties(vendorProperties)
				.mappingResources(getMappingResources()).jta(isJta()).build();
	}
~~~


