# Open-Entity

### Open Session In View

OSIV 는 영속성 컨텍스트를 뷰 렌더링이 끝나는 시점까지 개방한 상태로 유지하는 것입니다.

영속성과 관련된 모든 관심사는 도메인 객체로부터 격리된 채 관리자 객체에 의해 투명하게 처리되는데, 

이 관리자 객체의 기능을 담당하는 객체가 Hibernate의 Session 객체이며, 

Session 객체는 영속성 컨텍스트를 포함합니다.

하나의 Transaction동안 수정된 객체의 모든 상태는 영속성 컨텍스트 내에 저장되어, 

Transaction이 종료될 때 데이터 저장소에 동기화(flushing)됩니다. 

따라서 하이버네이트 Session을 하나의 작업 단위 동안 생성 및 조회, 수정, 삭제되는 객체의 상태를 보관하는 일종의 캐시로 간주해도 무방합니다.(실제로 하이버네이트 Session을 “1 차 캐시”라고 부르기도 합니다)

- EntityManager의 Life-Cycle 은  Transaction과 함께한다.

### Entity Status

- Persistence

Transaction 안에서 조회, 저장, 수정 등을 통해 가져온 영속성이 부여된 상태를 Persistence 상태라 하며,
Transient 상태의 객체도 강제로 Persistence 상태로 전환시킬 수 있습니다.

- Detached

Session.close() 메소드는 Session 을 닫고 영속성 컨텍스트를 포함밖 모든 자원을 반환하며, 
관리하에 있는 모든 영속 인스턴스를 Detached 상태로 변경시킵니다. 
하이버네이트는 Detached 상태의 객체에 대해서는 변경사항을 추적하지 않으며, 
따라서 데이터베이스와의 동기화 또한 수행하지 않습니다.

- Transient

new 연산자를 사용하여 생성한 객체는 곧바로 Persistence 상태가 되지 않고 Transient 상태를 갖게 됩니다.

- Removed

Transaction이 종료되는 시점에 삭제될 객체는 Removed 상태를 갖습니다.


### OpenEntityManagerInViewInterceptor

~~~java
EntityManager em = createEntityManager();
EntityManagerHolder emHolder = new EntityManagerHolder(em);
TransactionSynchronizationManager.bindResource(emf, emHolder);

AsyncRequestInterceptor interceptor = new AsyncRequestInterceptor(emf, emHolder);
asyncManager.registerCallableInterceptor(key, interceptor);
asyncManager.registerDeferredResultInterceptor(key, interceptor);
~~~



### References
- https://kingbbode.tistory.com/27