# NativeQuery

## RepositoryFactorySupport.QueryExecutorMethodInterceptor

~~~java
public Object invoke(@SuppressWarnings("null") MethodInvocation invocation) throws Throwable {

			Method method = invocation.getMethod();

			QueryExecutionConverters.ExecutionAdapter executionAdapter = QueryExecutionConverters //
					.getExecutionAdapter(method.getReturnType());

			if (executionAdapter == null) {
				return resultHandler.postProcessInvocationResult(doInvoke(invocation), method);
			}

			return executionAdapter //
					.apply(() -> resultHandler.postProcessInvocationResult(doInvoke(invocation), method));
		}
~~~

~~~java
		private Object doInvoke(MethodInvocation invocation) throws Throwable {

			Method method = invocation.getMethod();

			if (hasQueryFor(method)) {
				return queries.get(method).execute(invocation.getArguments());
			}

			return invocation.proceed();
		}
~~~