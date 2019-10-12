package com.googlecode.hotire.springdatajpa;

import java.util.TimeZone;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaApplication implements InitializingBean {

  public static void main(String[] args) {
    SpringApplication.run(SpringDataJpaApplication.class, args);
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
  }
}
