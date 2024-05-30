package org.woozi.pratice.jakarta.persistence.entity;

import java.lang.reflect.Field;

public class EntityColumnType {
    private final Class<?> javaType;


    public EntityColumnType(final Field field) {
        this(field.getType());
    }

    public EntityColumnType(final Class<?> javaType) {
        this.javaType = javaType;
    }

    public boolean isSameType(final Class<?> javaType) {
        return javaType.equals(this.javaType);
    }
}
