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