package org.woozi.pratice.jakarta.persistence.entity.strategy;

public class EntityColumnTypeLongDialectStrategy implements EntityColumnTypeDialectStrategy {
    private static final Class<?> JAVA_TYPE = Long.class;
    private static final String DIALECT = "BIGINT";

    @Override
    public boolean isJavaType(final Class<?> javaType) {
        return javaType.equals(JAVA_TYPE);
    }

    @Override
    public String query() {
        return DIALECT;
    }
}
