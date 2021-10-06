# HikariCP

## Query Internal 

- Simplify 

~~~java
Connection connection = null;
  PreparedStatement preparedStatement = null

  try {
    connection = hikariDataSource.getConnection();
    preparedStatement = connection.preparedStatement(sql);
    preparedStatement.executeQuery();
  } catch(Throwable e) {
    throw new RuntimeException(e);
  } finally {
    if (preparedStatement != null) {
      preparedStatement.close();
    }
    if (connection != null) {
      connection.close(); // 여기서 connection pool에 반납됩니다.
    }
  }
~~~


## HikariCP Dead lock

- o.h.engine.jdbc.spi.SqlExceptionHelper : SQL Error: 0, SQLState: null
- o.h.engine.jdbc.spi.SqlExceptionHelper : hikari-pool-1 – Connection is not available, request timed out after 30000ms.
- org.hibernate.exception.JDBCConnectionException: unable to obtain isolated JDBC connection
- Could not open JPA EntityManager for transaction; nested exception is org.hibernate.exception.JDBCConnectionException: Unable to acquire JDBC Connection

### References
- https://techblog.woowahan.com/2664/
