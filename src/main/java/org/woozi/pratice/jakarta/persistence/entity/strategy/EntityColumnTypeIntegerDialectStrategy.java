package org.woozi.pratice.jakarta.persistence.entity.strategy;

public class EntityColumnTypeIntegerDialectStrategy implements EntityColumnTypeDialectStrategy {
    private static final Class<?> JAVA_TYPE = Integer.class;
    private static final String DIALECT = "INT";

    @Override
    public boolean isJavaType(final Class<?> javaType) {
        return javaType.equals(JAVA_TYPE);
    }

    @Override
    public String query() {
        return DIALECT;
    }
}
