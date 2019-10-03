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


## Persistent Context 영속성 컨텍스트
엔티티를 저장하고, 관리하는 컨테이너 
(1차 캐시를 통해 해당 엔티티를 계속해서 보관하여, 사용할 수 있음)

### 1차 캐싱

### Write Behind
https://cocomo.tistory.com/334

### Lazy Loading


## Entity

Entity는 기본적으로 클래스 이름 사용한다.  (객체 세상에서 부르는 이름)

- @Table "릴레이션" 세상에서 부르는 이름 (기본적으로 @Entity 이름이 기본 값)

 
### Entity 상태

- Transient : JPA가 관리하지 않는 상태

- Persistent : JPA가 관리중인 상태

- Detached : JPA가 더이상 관리하지 않는 상태 

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


### 구현 클래스마다 테이블 Table Per Class

- not null 사용 가능!

- 자식 테이블을 함께 조회하기 힘들다. UNION 사용해야 한다..
 

 
## 기타

- JPQL

JPQL은 SQL과 비슷한 문법을 가진 객체 지향 쿼리입니다.

- QueryDSL

JPQL, SQL과 같은 쿼리를 생성할 수 있도록 해 주는 프레임워크

기존 SQL, JPQL는 Type-check가 불가능하고, 컴파일 시점에 알 수 있는 방법이 없다.

실제적으로 쿼리의 실행시점에 오류를 발견한다.

QueryDSL은 컴파일 시점에 문법 오류를 발견할 수 있고, 동적 쿼리이다.




  


