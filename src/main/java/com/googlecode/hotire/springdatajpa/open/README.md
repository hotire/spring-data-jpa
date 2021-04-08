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


### Open Session In View Pattern 

뷰 렌더링 시점에 영속성 컨텍스트가 존재하지 않기 때문에 Detached 객체의 프록시를 초기화할 수 없다면 영속성 컨텍스트를 오픈된 채로 뷰 렌더링 시점까지 유지하자는 것 입니다. 
즉, 작업 단위를 요청 시작 시점부터 뷰 렌더링 완료 시점까지로 확장하는 것 입니다.

사용자 화면을 구성하는 사용자 인터페이스 레이어(User Interface Layer), 
애플리케이션의 제어 흐름을 관리하는 애플리케이션 레이어(Application Layer), 도메인의 핵심 로직을 포함하는 도메인 레이어(Domain Layer), 
상위 계층을 지원하기 위한 인프라스트럭처 레이어(Infrastructure Layer)

- User Inteface Layer는 Paresentiation Layer
  
- Application Layer는 Service Layer
  
- Infrastructure Layer는 Persistence Layer(Data access Layer)
 
 
레이어 분리 원칙
 
1. 모델-뷰 분리(Model-View Separation)[Fowler PEAA, Larman AUP]
 
2. 깔끔하고 얇은 뷰(Clean and Thin View)[Johnson J2EEDD]
 
3. 영속성 분리(PI, Persistence Ignorance)[Nilsson ADDD]
 
4. 도메인 레이어 고립(Domain Layer Isolation)[Evans DDD]

서비스 레이어는 트랜잭션 경계를 정의하는 역할이라 이로 인해 Open Session In View Pattern 등장.

- 뷰 렌더링에 필요한 데이터 모두 로드
뷰에서 필요로 하는 모든 연관 관계의 객체를 `EAGER Fetch`로 설정하거나, Join 쿼리를 작성하는 방법입니다.
- POJO FACADE
애플리케이션 레이어 안에서 새로운 객체를 통해 프록시를 초기화한 후 사용자 인터페이스로 반한하는 방법입니다.

 
### FlushMode

// TODO



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


### 지연 로딩

- 페치 전략 : 쿼리 수행과 관련된 객체와 연관 관계를 맺고 있는 객체나 컬렉션 을 어느 시점에서 가져올지에 대한 전략 입니다. 

즉 데이터베이스에서 데이터를 가져 오는 전략을 정의합니다.

- 프록시 : 지연 페치 전략에 따라 연관 관계를 맺고 있는 객체와 컬렉션에는 실제 ENTITY 대신 실제 객체처럼 위장한 프록시(Proxy) 객체가 생성됩니다.
   

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