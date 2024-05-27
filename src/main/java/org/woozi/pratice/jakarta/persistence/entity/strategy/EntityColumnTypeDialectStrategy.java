package org.woozi.pratice.jakarta.persistence.entity.strategy;

public interface EntityColumnTypeDialectStrategy {
    boolean isJavaType(Class<?> javaType);

    String query();
}
