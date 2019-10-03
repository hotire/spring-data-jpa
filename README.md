# Spring-Data-Jpa

Study


## Entity

Entity는 기본적으로 클래스 이름 사용한다.  (객체 세상에서 부르는 이름)

- @Table "릴레이션" 세상에서 부르는 이름 (기본적으로 @Entity 이름이 기본 값)

 
### Entity 상태

- Transient : JPA가 관리하지 않는 상태

- Persistent : JPA가 관리중인 상태

- Detached : JPA가 더이상 관리하지 않는 상태 

- Removed : JPA가 관리하긴 하지만, 삭제하기로 한 상태


: Cascade : 엔티티의 상태를 전파 시키는 옵션


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


## N + 1

### Fetch Join

패치조인은 SQL에 존재하는 조인의 종류는 아니고 JPQL에서 성능 최적화를 위해 제공하는 기능이다.
 
연관된 엔티티나 컬렉션을 한번에 같이 조회하는 기능이다.

https://meetup.toast.com/posts/87
https://jojoldu.tistory.com/165


### Entity Graph



## Inheritance



 




  


