# SQL

## Statement

## PreparedStatement

Client side prepred statement: 초기 MySQL 서버가 PreparedStatement를 지원하지 못하던 시절에는 Client JDBC Driver에서 PreparedStatement를 흉내낼 수 있도록(표준 준수) Client side prepared statement를 지원했었는데, 이를 Client side prepared statement라고 합니다.
Server side prepared statement: 이후 MySQL 서버에서 PreparedStatement를 지원하게 되면서 실제 Client side에서 PreparedStatement emulation이 아닌 타 RDBMS와 동일한 방식의 PreparedStatement 기능을 지원하기 시작했는데, 이를 Server side prepared statement하고 합니다.
초기 MySQL 서버에서는 Text protocol(Text protocol이라고 해서 문자가 전송되는 프로토콜을 의미하는 것이 아니라 SQL 문장이 그대로 전달된다는 의미에서 Text protocol이라 함)만 지원했었는데, Server side prepared statement를 위해서는 새로운 프로토콜(Binary protocol)이 도입되었습니다. 현재 MRTE-Collector에서는 Binary protocol을 사용하는 경우는 지원하지 않고 있는데, 이는 패킷 분석의 어려움이 문제가 아니라 MRTE-Collector에서 PreparedStatement의 Hash Id를 알아낼 수 있는 방법이 없기 때문에 어려움이 있습니다.만약 MySQL 서버에서 Connection별로 만들어진 PreparedStatement의 dump가 가능하다면 향후 Binary protocol도 지원이 가능할 것으로 보입니다.

하지만 다행스럽게도, JDBC Client에서 server prepared statement의 사용 여부를 명시적으로 활성화하지 않으면 기본적으로는 Client side prepared statement가 사용되고 아직 MySQL 서버에서는 PreparedStatement의 장점이 그다지 크지 않아서 대부분의 경우 Statement 또는 Client side prepared statement를 사용하고 있는 상태입니다.

- https://tech.kakao.com/2016/02/16/opensource-2-mtre/