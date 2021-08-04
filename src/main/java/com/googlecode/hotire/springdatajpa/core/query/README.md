# Query 

### Query

### QueryImplementor

### AbstractProducedQuery


## Method Query

### RepositoryFactorySupport


### QueryExecutorMethodInterceptor implements MethodInterceptor 

- private final Map<Method, RepositoryQuery> queries;

### QueryLookupStrategy

- CreateIfNotFoundQueryLookupStrategy

### DefaultRepositoryInformation

~~~java
	@Override
	public Streamable<Method> getQueryMethods() {

		Set<Method> result = new HashSet<>();

		for (Method method : getRepositoryInterface().getMethods()) {
			method = ClassUtils.getMostSpecificMethod(method, getRepositoryInterface());
			if (isQueryMethodCandidate(method)) {
				result.add(method);
			}
		}

		return Streamable.of(Collections.unmodifiableSet(result));
	}
~~~
