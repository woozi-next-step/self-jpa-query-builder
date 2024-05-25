package org.woozi.pratice.jakarta.persistence.entity;

import java.util.Arrays;

public enum EntityColumnType {
    BIGINT("java.lang.Long", "BIGINT"),
    INT("java.lang.Integer", "INT"),
    VARCHAR("java.lang.String", "VARCHAR(255)");

    private final String javaType;
    private final String sqlType;

    EntityColumnType(final String javaType, final String sqlType) {
        this.javaType = javaType;
        this.sqlType = sqlType;
    }

    public static EntityColumnType of(final String type) {
        return Arrays.stream(values())
                .filter(it -> it.javaType.equals(type))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public String getJavaType() {
        return javaType;
    }

    public String getSqlType() {
        return sqlType;
    }
}

