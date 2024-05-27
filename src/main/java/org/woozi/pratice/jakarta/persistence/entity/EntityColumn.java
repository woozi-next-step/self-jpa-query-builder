package org.woozi.pratice.jakarta.persistence.entity;

import java.lang.reflect.Field;

public interface EntityColumn {
    String name();

    EntityColumnType type();

    EntityColumnOption option();

    default boolean hasPrimaryKey() {
        return false;
    }

    static EntityColumn of(final Field field) {
        if (field.isAnnotationPresent(Id.class)) {
            return new EntityColumnId(field);
        }
        return new EntityColumnField(field);
    }
}
