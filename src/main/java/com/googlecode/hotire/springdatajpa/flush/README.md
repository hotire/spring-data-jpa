# Flush

영속성 컨텍스트의 변경 내용을 DB 에 반영하는 것을 말한다.
Transaction commit 이 일어날 때 flush가 동작하는데, 이때 쓰기 지연 저장소에 쌓아 놨던 INSERT, UPDATE, DELETE SQL들이 DB에 날라간다.

(hibernate FlushMode의 경우 6가지)

JPA 지원 스펙은 2가지 COMMIT / AUTO 있다.

- AUTO : 기본 설정 값으로, Transaction 을 commit 하거나 Query를 실행할 때 flush()를 먼저 수행한다
- COMMIT : Transaction commit 할때만 flush()를 먼저 수행한다. Query를 실행할 때는 flush()를 먼저 수행하지 않는다.

~~~java
    /**
	 * The {@link Session} is only ever flushed when {@link Session#flush}
	 * is explicitly called by the application. This mode is very
	 * efficient for read only transactions.
	 */
	MANUAL( 0 ),

	/**
	 * The {@link Session} is flushed when {@link Transaction#commit}
	 * is called.
	 */
	COMMIT(5 ),

	/**
	 * The {@link Session} is sometimes flushed before query execution
	 * in order to ensure that queries never return stale state. This
	 * is the default flush mode.
	 */
	AUTO(10 ),

	/**
	 * The {@link Session} is flushed before every query. This is
	 * almost always unnecessary and inefficient.
	 */
	ALWAYS(20 );
~~~



### References
- http://wonwoo.ml/index.php/post/2181