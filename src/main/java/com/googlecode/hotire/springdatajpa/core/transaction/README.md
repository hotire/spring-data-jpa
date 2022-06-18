# Transaction

## Propagation

트랜잭션 전파 전략을 설정할 수 있다. 

또한 롤백에 대한 전략도 설정할 수 있다. 

- no-rollback-for : 롤백하지 않을 익셉션 타입
- rollback-for : 롤백할 익셉션 타입

### Propagation.REQUIRED

- default 

부모 트랜잭션 내에서 실행하며, 부모 트랜잭션이 없을 경우 새로운 트랜잭션 생성
호출한 곳에서 이미 트랜잭션이 설정되어 있다면 기존의 트랜잭션 내에서 로직을 실행한다.

### Propagation.REQUIRES_NEW

매번 새로운 트랜잭션을 시작한다. 

### Propagation.NESTED

부모 트랜잭션과 별개로 커밋, 롤백이 가능하다. 

DB 지원이 필요한데 ORACLE만 가능하다.

### Propagation.MANDATORY

부모 트랜잭션 내에서 실행되며, 부모 트랜잭션이 없을 경우 Exception이 발생한다.

### Propagation.SUPPORT

부모 트랜잭션이 존재하면 부모 트랜잭션으로 동작하고, 없을경우 non-transactional 하게 동작한다.

### Propagation.NOT_SUPPORTED

non-transactional 로 실행되며 부모 트랜잭션이 존재하면 일시 정지한다.

### Propagation.NEVER

non-transactional 로 실행되며 부모 트랜잭션이 존재하면 Exception이 발생한다.



## Isolation


## TransactionManager
org.springframework.transaction.TransactionManager

- PlatformTransactionManager
- ReactiveTransactionManager

### JpaTransactionManager

PlatformTransactionManager, AbstractPlatformTransactionManager의 구현체


## Rollback ISSUE

- https://techblog.woowahan.com/2606/

## References

- https://wave1994.tistory.com/178