# EntityListeners 

### SessionFactoryImpl

~~~java
public SessionFactoryImpl(
			final MetadataImplementor metadata,
			SessionFactoryOptions options) {
		LOG.debug( "Building session factory" );

		this.sessionFactoryOptions = options;
		this.settings = new Settings( options, metadata );

		this.serviceRegistry = options
				.getServiceRegistry()
				.getService( SessionFactoryServiceRegistryFactory.class )
				.buildServiceRegistry( this, options );

		prepareEventListeners( metadata );
~~~

SessionFactoryImpl is EntityManagerFactory

- prepareEventListeners 에서 SpringBeanContainerCore을 통해 EntityListeners을 Bean으로 등록한다.


### EventListenerRegistry

### CallbackBuilder

### ManagedBeanRegistry

### SpringBeanContainer

### CallbackRegistryImpl

### CallbackBuilderLegacyImpl

- resolveEntityCallbacks
    - managedBeanRegistry.getBean( listener )

### SpringBeanContainerCore


## Summary 

- EntityListeners bean 등록과정 EntityManagerFactory 생성시 SessionFactoryImpl 에서 prepareEventListeners 호출한다. CallbackRegistryImpl에 저장하게된다.
- 추후 저장하기전 CallbackRegistry로부터 preCreate / preUpdate를 호출하게 된다.
