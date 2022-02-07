# Lock

When the transaction needs to adhere to ACID rules strictly, we should use Pessimistic Locking. Optimistic Locking should be applied when we need to allow multiple concurrent reads and when eventual consistency is acceptable within the application context.

## Pessimistic Lock

선점 잠금은 스레드가 A 엔티티의 수정이 끝날 때까지 다른 스레드가 해당 엔티티 접근을 막는 방식이다. 

### Repository 

~~~java
@Lock(LockModeType.PESSIMISTIC_WRITE);
~~~


## References 
- https://www.baeldung.com/jpa-optimistic-locking
- https://www.baeldung.com/java-jpa-transaction-locks