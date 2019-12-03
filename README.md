# Spring-Data-Jpa

Study

## ORM(Object-Relational Mapping)

객체와 관계형 데이터베이스를 매핑하는 방법

### 패러마임의 불일치 해결

- Inheritance(상속)
RDBMS는 객체지향 프로그래밍 언어의 자연적 패러다임인 상속과 유사한 것을 정의하지 않는다.
즉, 상속의 개념이 없다.

- Identity(일치)
RDBMS는 ‘sameness’라는 하나의 개념을 정확히 정의하는데, 바로 ‘기본키(primary key)’이다.
그러나 자바에서는 객체 식별(a==b)과 객체 동일성(a.equales(b))을 모두 정의한다.
RDBMS에서는 PK가 같으면 서로 동일한 record로 정의하지만, Java에서는 주솟값이 같거나 내용이 같은 경우를 구분하여 정의한다.


### Persistent Context 영속성 컨텍스트

어플리케이션과 데이터베이스 사이에 존재하는 논리적인 개념으로 엔티티를 저장하는 환경을 의미한다.

최초로 엔티티의 상태를 저장해 두는데 이것을 스냅샵이라고 한다. 

플러시 시점에 스냅샷과 엔티티를 비교해서 업데이트 쿼리를 날린다.

엔티티를 저장하고, 관리하는 컨테이너 
(1차 캐시를 통해 해당 엔티티를 계속해서 보관하여, 사용할 수 있음)

- 오직 엔티티 매니저를 통해서 접근
 : entityManger.flush() / transaction.commit() / JPQL 쿼리 실행시 데이터베이스에 반영
 
- LifeCycle : PersistenceContext는 EntityManager가 닫힐 때까지 유지됩니다.


### EntityManagerFactory

persistence 설정 정보 (persistence.xml) 을 읽어서 JPA 기반 객체를 생성한다. 

데이터베이스 커텍션 풀도 생성하므로 엔티티 매니저 패곹리를 생성하는 비용은 아주 크다.

따라서 엔티티 매니저 팩토리는 애플리케이션 전체에서 딱 한 번만 생성하고 공유해서 사용해야 한다.

- 여러 스레드가 동시에 접근해도 안전하다. 

## EntityManger

엔터티 매니저는 데이터베이스를 위해 엔터티를 저장하고 수정하고 삭제하고 조회하는 등 엔터티와 관련된 모든일을 한다

엔티티 매니저는 특정 작업을 위해 데이터베이스에 액세스 하는 역할을 가진 친구이다.

또한 엔티티를 데이터베이스에 등록, 수정, 삭제, 조회할 수 있다.

엔티티와 관련된 모든 일을 처리하기에 이름 그대로 엔티티를 관리하는 관리자다.

일반적으로 엔티티 매니저와 영속성 컨텍스트가 1:1 매핑된다. (다수의 엔티티 매니저가 하나의 영속성 컨텍스트에 접근할 수도 있다.)

- LifeCycle : 프로토타입으로, Proxy로 감싸고 프록시로 EntityManger를 default로 

SharedEntityManagerCreator로 처리한다. Thread-safety하지 않기 때문에 매번 새롭게 EntityManger를 생성해서 처리한다.

한 마디로 트랜잭션과 동일한 라이프 사이클을 갖는다.

- MVC의 경우 OpenEntityManagerInViewInterceptor에 의해 preHandle에 의해
스레드 로컬에 EntityManger 를 주입하고 시작한다.
후 afterCompletion에서 해당 스레드 로컬을 지운다. 
 
- Webflux 경우 Interceptor를 사용하지 않고, 스레드 로컬을 지양하기 때문에

스레드 로컬에 EntityManger를 주입하지 않는다.

그렇기에 트랜잭션으로 묶이지 않은 이상, EntityManger의 메서드 호출 마다
새롭게 생성해서 사용한다.


### Flush 

플러시는 영속성 컨텍스트의 변경 내용을 데이터베이스에 반영한다.

플러시는 영속성 컨텍스트에 보관된 엔티티를 지운다고 생각하면 안된다. 

영속성 컨텍스트의 변경 내용을 데이터베이스에 동기화하는 것이 플러시다.


플러시 방법은 3가지다. 

1. flush() 직접 호출한다.

2. 트랜잭션 커밋 시 플러시가 자동 호출

3. JPQL 쿼리 실행 시 플러시가 자동 호출

```
em.persist(A);
em.persist(B);
em.persist(C);

List<Member> members = em.createQuery("select m from Member m", Member.class);
```

A, B, C 영속 상태로 만들었지만, 아직 데이터 베이스에 반영되지 않았다. 

하지만 중간에 JPQL를 통해 조회를 한다면 A, B, C 는 조회되지 않는다. 

이런 문제를 방지하고자 JPQL은 쿼리를 실행하기 직전에 영속성 컨텍스트를 플러시한다.


- MODE
  - FlushModeType.AUTO : 커밋이나 쿼리를 실행할 때 플러시 (기본 전략)
  - FlushModeType.COMMIT : 커밋할 떄만 플러시


### 1차 캐싱

### Write Behind

엔티티 매니저는 트랜잭션을 커밋하기 직전까지 데이터베이스에 엔티티를 저장하지 않고

내부 쿼리 저장소에 SQL을 차곡차곡 모아둔다. 그리고 커밋할 때 모아둔 쿼리를 데이터 베이스에 전송한다.

https://cocomo.tistory.com/334

### Lazy Loading


### Dirty Checking

엔티티의 변경사항을 데이터베이스에 자동으로 반영하는 기능이다.

영속성 컨텍스트가 관리하는 영속 상태의 엔티티에만 적용된다.

- JPA 기본 전략은 엔티티의 모든 필드를 업데이트 한다.
  - 모든 필드를 사용하면 수정 쿼리가 항상 같다. 따라서 애플리케이션 로딩 시점에 수정 쿼리를 미리 생성해두고 재사용할 수 있다.
  - 데이터베이스에 동일한 쿼리를 보내면 데이터베이스는 이전에 한 번 파싱된 쿼리를 재사용한다.
 
- 30개 이상의 컬럼이면, @DynamicUpdate를 사용해 동적 수정 퀴리를 고려해보자.   

## Entity

Entity는 기본적으로 클래스 이름 사용한다.  (객체 세상에서 부르는 이름)

- @Table "릴레이션" 세상에서 부르는 이름 (기본적으로 @Entity 이름이 기본 값)
 
### Entity 상태

- Transient : JPA가 관리하지 않는 상태

- Persistent : JPA가 관리중인 상태

- Detached : JPA가 더이상 관리하지 않는 상태 

  1. detach(entity) 
    : 특정 엔티티를 준영속 상태로 만든다.
  2. clear()
    : 해당 영속성 컨텍스트의 모든 엔티티를 준영속 상태로 만든다. 
  3. close()
    : 해당 영속성 컨텍스트의 모든 엔티티를 준영속 상태로 만든다. 

- Removed : JPA가 관리하긴 하지만, 삭제하기로 한 상태


### Cascade 

부모 엔티티의 상태를 전파 시키는 옵션

- CascadeType.PERSIST
   :  영속
  - cascade = CascadeType.PERSIST 로 지정하면 부모를 영속화할 때 연관된 자식들도 함께 영속화 한다.

- CascadeType.MERGE
  - 트랜잭션이 종료되고 detach 상태에서 연관 엔티티를 추가하거나 변경된 이후에 부모 엔티티가 merge()를 수행하게 되면 변경사항이 적용된다.
  - 연관 엔티티의 추가 및 수정 모두 반영됨

- CascadeType.REMOVE 
  - 삭제 시 연관된 엔티티도 같이 삭제됨
  - orphanRemoval(오펀리무벌)  옵션과의 차이점은 연관된 엔티티 중 하나가 삭제되는 경우이고 REMOVE 옵션은 부모 엔티티가 삭제된 경우 연관된 엔티티인 자식 엔티티까지 전부 삭제한다는 옵션이다.
    collections에서 제거되더라도 해당 로우를 삭제한다. 

- CascadeType.DETACH
  - 부모 엔티티가 detach()를 수행하게 되면, 연관된 엔티티도 detach() 상태가 되어 변경사항이 반영되지 않는다.

- CascadeType.ALL
  - 모든 Cascade 적용

- CascadeType.REFRESH
  - 엔티티를 새로 고칠 때, 이 필드에 보유 된 엔티티도 새로 고칩니다.


### 기본키 전략 

1. 직접 할당 : 기본 키를 애플리케이션에서 직접 할당한다. 

2. 자동 생성 : 대리 키 사용 방식

- IDENTITY : 기본 키 생성을 데이터베이스에 위임한다. 

- SEQUENCE : 데이터베이스 시퀀스를 사용해서 기본 키를 할당한다. 

- TABLE : 키 생성 테이블을 사용한다.

IDENTITY 와 SEQUENCE 전략이 비슷하지만, 

IDENTITY 의 경우 먼저 엔티티를 데이터베이스에 저장한 후에 식별자를 조회해서 엔티티의 식별자에 할당한다.

SEQUENCE 전략은 먼저 데ㅣ터베이스 시퀀스를 사용해서 식별자를 조회하고 영속성 컨텍스트에 저장한다.


### 레퍼런스 

1. @Enumerated 
```
enum Role {
  ADMIN, USER
}
```
 - ORDINAL : 순서를 데이터베이스에 저장 (ADMIN은 0, USER는 1)
 - STRING : 이름을 데이터베이스에 저장 (ADMIIN은 'ADMIN', USER는 'USER')
 



## Value 

### Type 종류

- 기본 Type (String, Integer, Boolean..)

- Composite Type

- Collection Type
  - 기본 Type
  - Composite Type
  

### Composite Type 맵핑
- @Embeddable

- @Embadded

- @AttributeOverrides

- @AttributeOverride

   
## Mapping

관계에는 항상 두 엔티티가 존재한다. 

- 둘 중 하나는 그 관계의 주인(owning), 다른 쪽은 종속된(non-owning)이다.

테이블은 외래 키 하나로 두 테이블의 연관관계를 관리한다.

반면, 객체에는 양뱡향 연관관계라는 것이 없다. 서로 다른 단방향 연관관계 2개를 애플리케이션 로직으로

잘 묶어서 양방향인 것 처럼 보이게 할 뿐이다.

엔티티를 양방향 연관관계로 설정하면 객체의 참조는 둘인데 외래 키는 하나다. 따라서 둘 사이에 차이가 발생한다.

따라서 두 객체 연관관계 중 하나를 정해서 테이블의 외래키를 관리해야 하는데 이것을 주인이라고 한다.

  
### 단방향 

관계를 정의한 쪽이 그 관계의 주인이다. 

1. ManyToOne
- 기본값은 FK 생성

2. OneToMany
- 기본 값은 조인 테이블 생성

### 양방향 

- FK 가지고 있는 Entity 가 주인, 기본 값은 @ManyToOne 가지고 있는 Entity 가 주인
- 주인이 아닌 Entity (@OneToMany)에서 mappedBy 를 통해 관계 설정
- 주인 Entity 관계를 설정해야 DB에 반영된다. 


### 조회

연관관계가 있는 엔티티를 조회하는 방법은 크게 2가지이다. 

1. 객체 그래프 탐색(객체 연관관계를 사용한 조회)

```
Team team = member.getTeam(); 
```

이처럼 객체를 통해 연관된 엔티티를 조회하는 것을 객체 그래프 탐색이라고 한다.


2. 객체지향 쿼리 사용 (JPQL)



## N + 1 Problem

### Fetch Join

패치조인은 SQL에 존재하는 조인의 종류는 아니고 JPQL에서 성능 최적화를 위해 제공하는 기능이다.
 
연관된 엔티티나 컬렉션을 한번에 같이 조회하는 기능이다.

- Fetch Join의 결과가 카테시안 곱이기 때문에 Set으로 반환한다.

https://meetup.toast.com/posts/87
https://jojoldu.tistory.com/165


### Entity Graph

엔티티들의 Fetch 전략을 컴파일 시점에 결정하게 되는데, 

런타임 시점에 관여한다.

## Inheritance 상속

### 단일 테이블 Single Table

테이블이 하나만 생성된다. 

- 조인이 필요 없다. 일반적으로 성능이 빠르다. (테이블이 점차 커져.. 느려질수도)
- 조회 쿼리가 단순하다.
- 단점으로 자식 엔티티가 매핑한 컬럼은 null을 허용 한다.


### @MappedSuperclass

@MappedSuperclass는 비유를 하자면 추상 클래스와 비슷한데 @Entity는 실제 테이블과 매핑되지만 @MappedSuperclass는 실제 테이블과 매핑 되지 않는다. 단순한 상속 목적으로 사용한다.



### 조인 전략 Joined

- 테이블이 정규화된다.

- 등록할 INSERT SQL을 두 번 실행한다.

- 조인이 많이 사용된다.

### 구현 클래스마다 테이블 Table Per Class

- not null 사용 가능!

- 자식 테이블을 함께 조회하기 힘들다. UNION 사용해야 한다..
 

 
## 기타

- JPQL

JPQL은 SQL과 비슷한 문법을 가진 객체 지향 쿼리입니다.

- Querydsl

JPQL, SQL과 같은 쿼리를 생성할 수 있도록 해 주는 프레임워크

기존 SQL, JPQL는 Type-check가 불가능하고, 컴파일 시점에 알 수 있는 방법이 없다.

Querydsl의 핵심 원칙은 타입 안정성(Type safety)이다. 도메인 타입의 프로퍼티를 반영해서 생성한 쿼리 타입을 이용해서 쿼리를 작성하게 된다. 또한, 완전히 타입에 안전한 방법으로 함수/메서드 호출이 이루어진다.

실제적으로 쿼리의 실행시점에 오류를 발견한다.

QueryDSL은 컴파일 시점에 문법 오류를 발견할 수 있고, 동적 쿼리이다.

- reference : http://www.querydsl.com/static/querydsl/4.0.1/reference/ko-KR/html_single/




  


