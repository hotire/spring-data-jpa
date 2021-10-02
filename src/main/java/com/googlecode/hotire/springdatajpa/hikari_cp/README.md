# HikariCP

## HikariCP Dead lock

- o.h.engine.jdbc.spi.SqlExceptionHelper : SQL Error: 0, SQLState: null
- o.h.engine.jdbc.spi.SqlExceptionHelper : hikari-pool-1 – Connection is not available, request timed out after 30000ms.
- org.hibernate.exception.JDBCConnectionException: unable to obtain isolated JDBC connection
- Could not open JPA EntityManager for transaction; nested exception is org.hibernate.exception.JDBCConnectionException: Unable to acquire JDBC Connection

### References
- https://techblog.woowahan.com/2664/
