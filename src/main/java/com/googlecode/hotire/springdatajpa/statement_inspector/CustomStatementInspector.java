package com.googlecode.hotire.springdatajpa.statement_inspector;

import org.hibernate.resource.jdbc.spi.StatementInspector;

public class CustomStatementInspector implements StatementInspector {

    @Override
    public String inspect(String sql) {
        return sql + "/* by hotire */";
    }
}
