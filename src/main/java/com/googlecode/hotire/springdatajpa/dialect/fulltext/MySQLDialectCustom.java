package com.googlecode.hotire.springdatajpa.dialect.fulltext;

import org.hibernate.dialect.MySQL5Dialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StandardBasicTypes;

public class MySQLDialectCustom extends MySQL5Dialect {
    public MySQLDialectCustom() {
        super();
        registerFunction("matchNatural", new SQLFunctionTemplate(StandardBasicTypes.STRING, "match(?1) against  (?2 in natural language mode)"));
    }
}
