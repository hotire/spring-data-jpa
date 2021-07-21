# Repository

## RepositoryProxyPostProcessor

- TransactionalRepositoryProxyPostProcessor

~~~
TransactionInterceptor transactionInterceptor = new TransactionInterceptor(null, transactionAttributeSource)...
factory.addAdvice(transactionInterceptor);
~~~