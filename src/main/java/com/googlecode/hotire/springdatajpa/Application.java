package com.googlecode.hotire.springdatajpa;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;

@EnableJpaAuditing(dateTimeProviderRef = "dateTimeProvider")
@SpringBootApplication
public class Application implements InitializingBean {

  @Autowired @Qualifier("coreRepository")
  private JpaRepositoryFactoryBean factoryBean;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
  }

  @Bean
  public DateTimeProvider dateTimeProvider() {
    return () -> Optional.of(OffsetDateTime.now());
  }
}
