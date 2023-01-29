package com.googlecode.hotire.springdatajpa.lazy;

import com.googlecode.hotire.springdatajpa.Application;
import com.googlecode.hotire.springdatajpa.core.data_source.routing.RoutingDataSource;
import com.googlecode.hotire.springdatajpa.core.data_source.routing.RoutingDataSource.DataSourceType;
import com.zaxxer.hikari.HikariDataSource;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
//@EnableJpaRepositories(
//    entityManagerFactoryRef = "entityManagerFactory",
//    transactionManagerRef = "transactionManager",
//    basePackages = { "com.googlecode.hotire.springdatajpa" }
//)
public class LazyDataSourceConfig {

    @Bean
    public DataSource lazyConnectionDataSourceProxy() {
        return new LazyConnectionDataSourceProxy(routingDataSource());
    }

    @Bean
    public DataSource routingDataSource() {
        final RoutingDataSource routingDataSource = new RoutingDataSource();
        routingDataSource.setTargetDataSources(Map.of(DataSourceType.READ_ONLY, readDataSource(), DataSourceType.READ_WRITE, mainDataSource()));
        routingDataSource.setDefaultTargetDataSource(mainDataSource());
        return routingDataSource;
    }

    @Bean
    @Primary
    @ConfigurationProperties("datasource.main")
    public DataSource mainDataSource() {
        return dataSource();
    }

    @Bean
    @ConfigurationProperties("datasource.read")
    public DataSource readDataSource() {
        return dataSource();
    }

    private DataSource dataSource() {
        return new HikariDataSource();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(lazyConnectionDataSourceProxy())
            .packages(Application.class.getPackageName())
            .properties(Map.of(
                "hibernate.id.new_generator_mappings", false,
                "hibernate.hbm2ddl.auto", "create"
            ))
            .persistenceUnit("main")
            .build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
        final JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(entityManagerFactory(builder).getObject());
        return tm;
    }

    @Configuration
    @EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager",
        basePackages = { "com.googlecode.hotire.springdatajpa" }
    )
    public static class Inner {

    }

}
