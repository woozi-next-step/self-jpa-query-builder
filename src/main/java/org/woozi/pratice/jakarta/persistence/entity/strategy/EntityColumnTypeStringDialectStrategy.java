package org.woozi.pratice.jakarta.persistence.entity.strategy;

public class EntityColumnTypeStringDialectStrategy implements EntityColumnTypeDialectStrategy {
    private static final Class<?> JAVA_TYPE = String.class;
    private static final String DIALECT = "VARCHAR(255)";

    @Override
    public boolean isJavaType(final Class<?> javaType) {
        return javaType.equals(JAVA_TYPE);
    }

    @Override
    public String query() {
        return DIALECT;
    }
}
