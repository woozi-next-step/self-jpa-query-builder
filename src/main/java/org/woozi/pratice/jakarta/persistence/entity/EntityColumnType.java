package org.woozi.pratice.jakarta.persistence.entity;

public class EntityColumnType {
    private final Class<?> javaType;

    EntityColumnType(final Class<?> javaType) {
        this.javaType = javaType;
    }

    public boolean isSameType(final Class<?> javaType) {
        return javaType.equals(this.javaType);
    }
}
