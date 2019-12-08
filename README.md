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


### 값 타입의 특징 

- 식별자가 없다.

- 생명 주기를 엔티티에 의존한다. 

- 공유하지 않는 것이 안전하다. 
  - 대신에 값을 복사해서 사용하자.
  - 오직 하나의 주인만이 관리해야 한다.
  - 불변으로 만드는 것이 안전하다.

- 값 타입 콜렉션 사용시, 수정이 일어나면 전부 삭제하고 다시 저장한다.
  
  


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


### 식별 관계 vs 비식별 관계

외래키가 기본 키에 포함되는지 여부에 따라 식별 고나계와 비식별 관계로 구분한다.


- 식별 관계 매핑 시, @IdClass or @EmbeddedId를 사용해서 식별자를 매핑해야 한다.


   
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
 


# 객제지향 쿼리 언어

## JPQL

JPQL은 SQL과 비슷한 문법을 가진 객체 지향 쿼리입니다.

- 테이블이 아닌 객체를 대상으로 검색하는 객체지향 쿼리다.

- SQL을 추상화해서 특정 데이터베이스 SQL에 의존하지 않는다.


영속성 컨텍스트에 있는 데이터를 고려하지 않고 데이터베이스에서 데이터를 조회하기 떄문에 

항상 JPQL을 실행하기 전에 영속성 컨텍스트의 내용을 데이터베이스에 반영해야 한다. 


### 문법

```
select_문 :: = 
  select_절
  from_절
  [where_절]
  [groupby_절]
  [having_절]
  [orderby_절]
  
update_문 :: = update_절 [where_절]
delete_문 :: = delete_절 [where_절]  
```


- 대소문자 구분
  엔티티와 속성은 대소문자를 구분한다. 예를 들어 Member, username은 대소문자를 구분한다.
  반면, SELECT / FROM / AS 같은 JPQL 키워드는 대소문자를 구분하지 않는다.
  
- 별칭 필수
  Member AS m 을 보면 Member 엔티티에 별칭을 주었다. JPQL은 별칭은 필수로 사용해야 한다.
  AS는 생략할 수 있다.
  
   
- 콜렉션 결과가 없으면 빈 컬렉션을 반환한다. 

- 하나 요청시, 결과가 없으면 NoResultException 발생 / 결과가 1개보다 많으면 NonUniqueResultException이 발생한다.


### 파라미터 바인딩

JDBC는 위치 기 파라미터 바인딩만 지원하지만, JPQL은 이름 기준 파라미터 바인딩도 지원한다.

- 이름 기준 바인딩 : 앞에 ':' 를 사용한다.

```
select m from Member m where m.username = :username


setParameter("username", ...)
```


- 위치 기준 바인딩 : '?' 다음에 위치 값을 주면 된다.

```
select m from Member m where m.username = ?1


setParameter(1, ...)
```



파라미터 바인딩을 사용하면 SQL 인젝션 방어를 할 수도 있고, 

애플리케이션 JPQL을 SQL로 파싱한 결과를 재사용할 수 있다. 또한 데이터베이스 내부에서도

SQL을 파싱한 결과를 재사용한다. 그러므로 꼭 쓰자. :) 


### Projection 프로젝션

SELECT 절에서 조회할 대상을 지정하는 것을 프로젝션이라 한다.

프로젝션 대상으로 엔티티, 엠비디드 타입, 스칼라 타입이 있다. (스칼라 타입은 숫자, 문자 등 기본 데이터 타입)

- 엠비디드 타입은 엔티티가 아닌 값 타입으로 영속성 컨텍스트에서 관리되지 않는다.


### 페이징 

JPA는 페이징을 다음 두 API로 추상화했다.


- setFirstResult(int startPosition) : 조회 시작 위치 (0부터 시작)

- setMaxResult(int maxResult) : 조회할 데이터 수

### 집합

집한은 통계 정보를 구할 떄 사용한다. 

```
select 
  COUNT(m),      // 회원수
  SUM(m.age),    // 나이 합
  AVG(m.age),    // 평균 나이
  MAX(m.age),    // 최대 나이
  MIN(m.age),    // 최소 나이
from Member m  
```

주의 사항
- NULL 값은 무시하므로 통계제 잡히지 않는다.

- 만약 값이 없는데 SUM, AVG, MAX, MIN 함수를 사용하면 NULL 값이 된다. COUNT는 0

- DISTINCT를 집합 함수 안에서 사용해서 중복된 값을 제거하고 나서 집합을 구할 수 있다. 

  - ex) select COUNT(DISTINCT m.age) from Member m

- DISTINCT를 COUNT에서 사용할 떄 임베디드 타입을 지원하지 않는다.


### 조인

- 내부조인 : INNER JOIN를 사용한다. INNER을 생략할 수 있다.

- 외부조인 : OUTER는 생략 가능해서 보통 LEFT JOIN으로 사용한다.

- 세타조인 : 내부 조인만 지원한다.

JPA 2.1 이후부터 JOIN ON을 지원한다.

- 패치 조인 : SQL 조인은 아니고, JPQL에서 성능 최적화를 위해 제공하는 기능이다.
            연관된 엔티티나 컬렉션을 한 번에 같이 조회하는 기능이다. (join fecth)

  - 패치 조인의 특징과 한계
    - SQL 한 번으로 연관된 엔티티들을 함께 조회할 수 있어서 성능 최적화를 할 수 있다.
    - 패치 조인 대상에는 별칭을 줄 수 없다. 따라서 SELECT, WHERE 절 서브 쿼리에 패치 조인 대상을 사용 할 수 없다.
    - 둘 이상의 컬렉션을 패치 할 수 없다. 
    - 컬렉션을 패치 조인하면 페이징 API를 사용할 수 없다. (일대다가 아닌 일대일, 다대일은 가능)
    
    
### 경로 표현식

경로 표현식을 쉽게 설명하면, .(점)을 찍어 객체 그래프를 탐색하는 것이다.

m.username, m.team 모두 경로 표현식을 사용한 예다.


- 상태 필드 : 단순히 값을 저장하기 위한 필드

- 연관 필드 : 연관관계를 위한 필드, 임베디드 타입 포함
  - 단일 값 연관 필드 : @ManyToOne, @OneToOne 와 같이 대상이 엔티티
  - 컬레션 값 연관 필드 : @OneToMany, @ManyToMany 와 같이 대상이 컬렉션
  
  

상태 필드 경로는 겸로 탐색의 끝이다. 더는 탐색할 수 없다. 단일, 컬렉션 값 연관 경로는 묵시적으로 내부 조인이 일어난다.

단일 값은 계속해서 탐색하지만, 컬렉션은 탐색이 불가능하다. 단 FROM절에서 조인을 통해 별칭을 얻으면 별칭으로 탐색이 가능하다.


1. 상태 필드 경로 탐색 

- JPQL
```
select m.username, m,age from Member m
```

- SQL
```
select m.username, m.age from Member m
```
  

2. 단일 값 연관 경로 탐색

- JPQL

```
select o.member from Order o
```          

- SQL

```
select m.*
from Order o 
  inner join Member m on o.member_id = m.id   

```
단일 값 연관 필드로 경로 탐색을 하면 SQL에서 내부 조인이 발생한다.

명시적으로 JOIN을 직접 적어줄 수 있다. 묵시적으로 조인이 일어나면 무조건 내부조인!!

```
select m from Member m join m.team t
```
ex) 명시적 조인
          

2. 컬렉션 값 연관 경로 탐색

JPQL을 다루면서 가장 많이 하는 실수 중 하나는 컬렉션 값에서 경로 탐색을 시도하는 것이다. 


```
select t.members from Team t  // 성공 
select t.members.username from Team t // 실패 
```

t.members 처럼 컬렉션까지는 경로 탐색이 가능하지만, t.members.username처럼 컬렉션에서 경로 탐색을 시도하는 것은 불가능하다.
만약 컬렉션에서 경로 탐색을 하고 싶으면 새로운 별칭을 획득해야 한다.

```
select m.username from Team t join t.members m
``` 

- 경로 탐색시 주의 사항
  - 항생 내부 조인이다.
  - 컬렉션은 경로 탐색의 끝이다. 경로 탐색을 하기 위해선 명시적으로 조인해서 별칭을 얻어야 한다.
  - 경로 탐색은 주로 SELECT, WHERE 절에서 사용하지만 묵시적 조인으로 인해 SQL FROM 절에 영향을 준다.
  - 조인이 성능적으로 차지하는 부분은 크다. 또한 묵시적 조인이 일어나는 상황을 한 눈에 파악하기 힘들다. 
    성능이 중요한 부분이면 명시적 조인을 사용하자. 
        

### 서브 쿼리

JPQL도 SQL처럼 서브 쿼리를 지원한다. 단 몇가지 제약이 있는데 서브 쿼리를 WHERE, HAVING 절에만 사용할 수 있고

SELECT, FROM 절에는 사용할 수 없다. 


- ex) 나이가 평균보다 많은 회원을 찾는다. 
```
select m from Member m 
where m.age > (select  avg(m2.age) from Member m2)
```

- ex) 한 건이라도 주문한 고객을 찾는다. 

```
select m From Member m 
where (select count(o) from Order o where m = o.member) > 0
```

참고로 이 쿼리는 다음처럼 컬렉션 값 연관 필드의 size 기능을 사용해도 같은 결과를 얻을 수 있다. (실행되는 SQL도 같다.)

```
select m from Member m 
where m.orders.size > 0
```


- 서브 쿼리 함수 : 서브 쿼리는 다음 함수들과 같이 사용할 수 있다. 
  - [NOT] EXISTS (subquery)
    서브 쿼리에 결과가 존재하면 참이다. 
    
    ex) 팀A 소속인 회원
    ```
    select m from Member m 
    where exists (select t from m.team t where t.name = '팀A')
    ```
  - [ALL | ANY | SOME] (subquery)
    - ALL : 조건을 모두 만족하면 참이다. 
    - ANY 혹은 SOME : 조건을 하나라도 만족하면 참이다. 
    
    ex) 전체 상품 각각의 재고보다 주문량이 많은 주문들 
    ```
    select o from Order o
    where o.orderAmount > ALL (select p.stockAmount from Product p)
    ```
    
    ex) 어떤 팀이든 팀에 소속된 회원
    ```
    select m from Member m
    where m.team = ANY (select t from Team t)
    ```
  - [NOT] IN (subquery)
    서브쿼리의 결과 중 하나라도 같은 것이 있으면 참이다. 
    
    ex) 20세 이상을 보유한 팀 
    ```
    select t from Team t 
    where t IN (select t2 from Team t2 JOIN t2.members m2 where m2.age >= 20)
    ```
    
### 조건식 

- 타입 표현 
  - 문자 : ''작은 따옴표 사이에 표현한다. 
  - 숫자 : L, D ,F 사용한다.
  - 날짜 : {d '2012-10-01'}, {t '10-11-11'}, {ts '2012-03-04 10-11-11.123'}
  - Enum : 패키지명을 포함한 전체 이름을 사용해야 한다. com.github.hotire.ADMIN
  - 엔티티 타입 : 엔티티의 타입을 표현한다. 주로 상속과 관련해 사용 TYPE(m) = Member


- 연산자 우선 순위
  1. 경로 탐색 연산 (.)
  2. 수학 연산 : +, -(단항 연산자), *, /, +, -
  3. 비교 연산 : =, >, <, <>, [NOT] BETWEEN, LIKE, IN, IS [NOT] NUL | EMPTY, EXISTS 
  4. 논리 연산 : NOT, AND, OR

- 컬렉션 식 : 컬렉션에만 사용하는 특별한 기능이다. 
  - 빈 컬렉션 비교식 : {컬렉션 값 연관 경로} IS [NOT] EMPTY
  
  ex) 주문이 하나라도 있는 회원 조회  
  ```
  select m from Member m where m.orders is not empty
  ```
  
  - 컬렉션의 멤버 식 : 엔티티나 값이 컬렉션에 포함되어 있으면 참 
  ```
  select t from Team t 
  where :memberParam member of t.members
  ```
  
- 스칼라 식 : 숫자, 문자, 날짜 case, 엔티티 타입 기본적인 타입들을 말한다. 
  - https://joont92.github.io/jpa/JPQL/ 너무 많으니... 여기서 보자 
  
- CASE 식 : 특정 조건에 따라 분기할 떄 CASE 식을 사용한다. 4가지 종류가 있다. 
  - https://joont92.github.io/jpa/JPQL/ 이것도 마찬가지..
  

### 다형성 쿼리 

JPQL로 부모 엔티티를 조회하면 그 자식 엔티티도 함께 조회한다. 

- TYPE : 상속 구조에서 조회 대상을 특정 자식 타입으로 한정할 때 주로 사용한다. 
  ```
  select i from Item i 
  where type(i) IN (Book, Movie)
  ```

- TREAT (JPA 2.1) : 자바의 타입 캐스팅과 비슷하다. 상숙 구조에서 부모 타입을 특정 자식 타입으로
  다룰 때 사용한다. 
  ```
   select i from Itme i where treat(i as Book).author = 'kim'
  ```
 

### 사용자 정의 함수 (JPA 2.1)

function_invocation:: = FUNCTION(function_name {, funtion_arg}*)

```
select function('group_concat', i.name) from Item i 
``` 

### NULL 

- 조건을 만족하는 데이터가 하나도 없으면 NULL 이다.
- NULL은 알 수 없는 값이다. NULL과 모든 수학적 계산 결과는 NULL이다. 
- NULL == NULL은 NULL 이다. 
- NULL IS NULL은 참이다. 


### Named 쿼리 : 정적 쿼리 

JPQL 쿼리는 크게 동적 쿼리와 정적 쿼리로 나눌 수 있다. 

- 동적 쿼리 : em.createQuery(...) 처럼 JPQL을 문자로 완성해서 직접 넘기는 것을 동적 쿼리

- 정적 쿼리 : 미리 정의한 쿼리에 이름을 부여해서 필요할 떄 사용하는 쿼리 


Named 쿼리는 애플리케이션 로딩 시점에 JPQL 문법을 체크하고 머리 파싱해둔다. 

따라서 오류를 빨리 확인할 수 있고, 사용하는 시점에 파싱된 결과를 재사용하므로 성능상 이점이 있다. 

- Named 쿼리는 영속성 유닛 단위로 관리되므로 충돌을 방지하기 위해 엔티티 이름을 앞에 통상적으로 준다.
- XML / Annotation 같은 설정이 있으면 XML이 우선권을 갖는다. 


## Criteria 

JPQL을 생성하는 빌더 클래스다. 문자가 아닌 코드로 JPQL을 작성할 수 있다.

코드이기 때문에, 런타임 시점이 아닌 컴파일 시점에 오류를 발견할 수 있다.

- Annotation Processor 기능을 통해 만들어진 메타 모델을 사용하면 온전히 코드만 사용해서 쿼리를 작성할 수 있다.


```
  @Test
  public void findAll() {
    final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    final CriteriaQuery<Account> criteriaQuery = cb.createQuery(Account.class);

    final Root<Account> accountRoot = criteriaQuery.from(Account.class);  // FROM
    criteriaQuery.select(accountRoot);                                    // SELECT

    final TypedQuery<Account> query = entityManager.createQuery(criteriaQuery);
    final List<Account> accounts = query.getResultList();
  }
```
- Query Root 
  - 쿼리 루트는 조회의 시작점이다. 
  - Criteria 에서 사용하는 특병할 별칭이다. 
  - 별칭은 엔티티에만 부여할 수 있다. 
  - root.get("team").get("name") JPQL m.team.name과 같다. 


### 집합 

- Group By

- HAVING 

- 조인 : join() 메서드와 JoinType 클래스를 사용한다. 

```
m.join("team")                  // 내부 조인 
m.join("team", JoinType.INNER); // 내부 조인 
m.join("team",JoinType.LEFT);   // 외부 조인
m.fetch("team", JoinType.LEFT)  // 패치 조인 
```
 
## QueryDSL

JPQL, SQL과 같은 쿼리를 생성할 수 있도록 해 주는 프레임워크

기존 SQL, JPQL는 Type-check가 불가능하고, 컴파일 시점에 알 수 있는 방법이 없다.

Querydsl의 핵심 원칙은 타입 안정성(Type safety)이다. 도메인 타입의 프로퍼티를 반영해서 생성한 쿼리 타입을 이용해서 쿼리를 작성하게 된다. 또한, 완전히 타입에 안전한 방법으로 함수/메서드 호출이 이루어진다.

실제적으로 쿼리의 실행시점에 오류를 발견한다.

QueryDSL은 컴파일 시점에 문법 오류를 발견할 수 있고, 동적 쿼리이다.

- reference : http://www.querydsl.com/static/querydsl/4.0.1/reference/ko-KR/html_single/

### 기본 Q 생성

사용하기 편하게 기본 인스턴스를 보관하고 있다. 

같은 엔티티를 조인하거나 서브쿼리에 사용하면 같은 별칭이 사용되므로, 이때는 별칭을 지정해서 사용해야 한다.


### 수정, 삭제 배치 쿼리 

QueryDSL 도 수정, 삭제 같은 배치 쿼리를 지원한다. JPQL 배치 쿼리와 같이 영속성 컨텍스트를 무시하고

데이터베이스를 직접 쿼리한다는 점에 유의하자. 


## 네이티브 SQL

JPQL은 표준 SQL 지원하는 대부분의 문법과 SQL 함수들을 지원하지만 특정 데이터베이스에 종속적인 기능은 지원하지 않는다. 

- 특정 데이터베이스만 지원하는 함수 

- 인라인 뷰, UNION, INTERSECT 

- 스토어드 프로시저  


네이티브 SQL를 사용하면 엔티티를 조회할 수 있고 JPA가 지원하는 영속성 컨텍스트의 기능을 그대로 사용 가능하다.

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



## Spring Data JPA

### 명세 
TODO 


### 스프링 컨테이너의 기본전략 
스프링 컨테이너는 트랜잭션 범위의 영속성 컨텍스르틀 사용한다. 

트랜잭션이 끝난 영역에서 엔티티는 준영속 상태이다. 따라서 변경 감지, 지연 로딩이 동작하지 않는다.


### 준영속 상태와 지연 로딩 

준영속 상태의 지연 로딩을 시도하면 LazyInitializationException 예외가 발생한다. 

준영속 상태의 지연 로딩 문제 해결 방법은 크게 2가지이다. 

- 뷰가 필요한 엔티티를 미리 로딩
  1. 글로벌 페치 전략 수정 : FetchType.EAGER
    - 사용하지 않는 엔티티를 로딩한다. 
    - N + 1 문제가 발생한다. (JPA가 글로벌 패치 전략을 참고하지 않고 JPQL 자체만 사용한다.)
  2. JPQL 페치 조인 : join fetch
    - 글로벌 페치 전략은 애플리케이션 전체 영향 / N + 1 문제가 발생한다. 
    - 페치 조인을 사용하면 조인 대상까지 함께 조회한다. 
    - 무붐별하게 사용하면 화면에 맞춘 리포지터리 메소드가 증가할 수 있다. 
  3. 강제로 초기화 : 말 그대로 강제로 초기화한다. 
    - FACADE 패턴 

- OSIV를 사용해서 엔티티를 항상 영속 상태로 유지 
 
   
### OSIV 
Open Session In View 영속성 컨테스트를 뷰가지 열어둔다는 뜻이다.

영속성 컨텍스트가 살아있으면 엔티티는 영속 상태로 유지되고 뷰에서도 지연 로딩을 사용할 수 있다.


- 요청 당 트랜잭션 
가장 단순한 구현 방법은 클라이언트의 요청이 들어오자마자 서블릿 필터나 스프링 인터셉터에서 트랜잭션을 시작하고  요청이 끝날 때 트랜잭션도 끝내는 것이다. 요청 당 트랜잭션 방식이다. 
  - 문제점 : 컨트롤러나 뷰계층이 엔티티를 변경할 수 있다는 점이다. 수정 하지 못하게 읽기 전용 / Wrapper / DTO 사용하자 .
  
- 비지니스 계층 트랜잭션 
스프링 프레임워크가 제공하는 OSIV이다. 비즈니스 계층에서만 트랜잭션을 사용한다 서비스 계층이 끝나면 트랜잭션을 종료하지만, 영속성 컨텍스트는 종료하지 않고 컨트롤러와 뷰에게 제공한다.  
  - 트랜잭션 없이 읽기 : 트랜잭션 없이 엔티티를 변경하고 영속성 컨테스를 플러시하면 예외가 발생한다. 
  엔티티를 변경하지 않고 단순히 조회만 할 때는 트랜잭션이 없어도 되는데 이것을 트랜잭션 없이 읽기라 한다.
  - 프리젠테이션 계층에서 엔티티를 수정한 직후 트랜잭션 서비스 계층을 호출하면 문제가 발생한다. 
  
   
## 프록시 심화 

### 영속성 컨텍스트와 프록시 

getReference() 메서드를 통해 프록시를 얻어어고, find()메서드를 통해 엔티티를 조회하면 

영속성 컨텍스트는 원본이 아닌 프록시를 반환한다. 따라서 동일성을 보장한다. 

반대로 엔티티를 먼저 조회하고 프록시를 얻어오려고 하면 원본을 반환한다. 

### 프록시 타입 비교 

프록시는 원본 엔티티를 상속 받아서 만들어지므로 타입 비교는 instanceof를 사용해야 한다. 

### 프록시 동등성 비교 

프록시의 경우 equals() 문제가 발생할 수 있다. 

instanceof 를 사용하지 않은 경우, getter를 사용하지 않고 필드에 직접 접근 할 경우 아무 값도 조회할 수 없다. 

### 상속 

프록시를 부모 타입으로 조회하면 문제가 발생한다. 

프록시는 부모 기반으로 만들어지기 때문에 하위 자식과 관련이 없다. 

- 하이버네이트가 제공하는 프록시 벗기기를 통해서 원본 엔티티를 얻어오자. 
- Visitor 패턴 
   
    
## 기타 

### 벌크 연산 

엔티티를 수정하려면 영속성 컨텍스트의 변경 감지, 병합, 삭제하려면 엔티티 매니저의 remove() 

메서드를 사용한다. 하지만 이 방법으로 수백만개 이상의 엔티티를 하나씩 처리하기에는 시간이 오래 걸린다.

이럴 떄 필요한 것이 벌크 연산이다.


- 벌크 연산은 영속성 컨텍스트를 무시하고 데이터베이스에 직접 쿼리한다는 점에 주의해야 한다. 
  - [dirtyReadByBulk](https://github.com/hotire/spring-data-jpa/blob/master/src/test/java/com/googlecode/hotire/springdatajpa/AccountTest.java)


### Find vs JPQL 

entityManager.find() 메서드는 엔티티를 영속성 컨텍스트에서 먼저 찾고 없으면 데이터베이스에서 찾는다.(1차 캐시)

따라서 성능상 이점이 있다. 반면 JPQL은 항상 데이터베이스에서 SQL을 실행해서 결과를 조회한다. 

그 후 영속성 컨텍스트에 이미 존재한다면 보관하고 있던 엔티티를 반환한다. 



### 콜렉션 

- Collection, List는 엔티티를 추가할 때 중복 검사를 하지 않고 단순히 저장한다. 따라서 지연 로딩된 컬렉션을 초기화하지 않는다.

- Set는 중복 검사를 하기 때문에 엔티티를 추가할 때 지연 로딩된 컬렉션을 초기화한다.

- List + @OrderColumn 을 사용시 순서 값을 저장해서 조회한다. 내부 컬렉션 PersistentList를 사용한다.
  - 순서가 있는 컬렉션은 데이터베이스에 순서 값도 함께 관리하기 때문에 실무에서 잘 사용하지 않는다. 
  

### Converter 

컨버터를 사용하면 엔티티의 데이터를 변환해서 데이터베이스에 저장할 수 있다.


### 리스너 

엔티티의 생명주기에 따른 이벤트를 처리할 수 있다. 

1. 엔티티에 직접 사용

2. 별도의 리스너 등록 

3. 기본 리스너 사용


여러 리스너를 등록했을 때 이벤트 호출 순서는 다음과 같다. 

- 기본 리스너

- 부모 클래스 리스너

- 리스너 

- 엔티티 

: 어노테니션을 통해 기본 리스너 / 부모 클래스 리스너 를 무시할 수 있다. 


### 엔티티 그래프 

TODO 


### 예외 처리 

JPA 예외는 크게 2가지로 나눌수 있다. 

- 트랜잭션 롤백을 표시하는 예외 

- 트랜잭션 롤백을 표시하지 않는 예외 

트랜잭션 롤백을 표시하는 예외는 심각한 예외이므로 복구해선 안된다. 

반면 트랜잭션 롤백을 표시하지 않는 예외는 심각한 예외가 아니다. 따라서 개발자가 커밋할지 롤백할지 판단하면 된다. 


- 트랜잭션 롤백시 주의 사항 

트랜잭션을 롤백하는 것은 데이터베이스의 반영사항만 롤백하는 것이지, 수정한 자바 객체까지 원상태로 복구해주지 않는다. 

따라서 롤백 후, 남아있는 영속성 컨텍스트를 그대로 사용하는 것은 위험하다. 초기화하고 사용하자. 

(트랜잭션 당 영속성 컨텍스트는 롤백하면 같이 종료되므로 상관 없다.) 


### 엔티티 비교 

- 영속성 컨텍스트가 같을 경우 
  - 동일성
  - 동등성 
  - 데이터베이스 동등성
3가지 모두 만족한다. 

- 영속성 컨텍스트가 다를 때 
  - 동등성 (물론 equals 오버라이딩을 했을 때) 
  - 데이터베이스 동등성

동일성 비교에서는 다르다고 나타난다. 


### 배치 처리 주의사항 
수천에서 수만 건 이상의 엔티티를 한 번에 등록할 때 영속성 컨텍스트에 엔티티가 계속 쌓이지 

않도록 일정 단위마다 데이터베이스에 플러시하고 초기화해야 한다. 너무 많은 엔티티가 쌓여 메모리 부족 오류가 발생할 수 있다. 





   
  