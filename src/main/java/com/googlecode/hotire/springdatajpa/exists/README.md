# exists

method query에서 exists를 지원하지만 @Query에서는 exists를 지원하지 않는다. 그렇기에 count로 우회해서 사용한다.

### count vs exists

이는 exists는 첫번째 결과에서 바로 true 를 리턴하면 되지만, 

count의 경우엔 결국 총 몇건인지 확인하기 위해 전체를 확인해봐야하기 때문에 성능 차이는 당연할 수 밖에 없습니다.

### Querydsl

Querydsl에서는 from절 없이는 쿼리를 생성할 수 없습니다.

fetchFirst() 대체 사용한다.

fetchFirst() 는 내부적으로 limit(1).fetchOne() 로 되어있습니다.

실제 method query도 결국 limit 1를 사용한다.

