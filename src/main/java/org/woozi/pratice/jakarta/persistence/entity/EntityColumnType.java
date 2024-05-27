package org.woozi.pratice.jakarta.persistence.entity;

public class EntityColumnType {
    private final Class<?> javaType;

    EntityColumnType(final Class<?> javaType) {
        this.javaType = javaType;
    }

    public Class<?> javaType() {
        return javaType;
    }

    public boolean isInteger() {
        return javaType.equals(Integer.class);
    }

    public boolean isLong() {
        return javaType.equals(Long.class);
    }

    public boolean isString() {
        return javaType.equals(String.class);
    }
}
