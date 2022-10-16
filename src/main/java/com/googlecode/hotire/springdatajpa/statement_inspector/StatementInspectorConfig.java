package com.googlecode.hotire.springdatajpa.statement_inspector;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StatementInspectorConfig {
    @Bean
    public HibernatePropertiesCustomizer hibernatePropertyConfig() {
        return hibernateProperties ->
            hibernateProperties.put(AvailableSettings.STATEMENT_INSPECTOR, new CustomStatementInspector());
    }
}
