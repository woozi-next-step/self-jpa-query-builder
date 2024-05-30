package org.woozi.pratice.jakarta.persistence.entity;

import org.woozi.pratice.jakarta.persistence.entity.annotation.EntityColumn;

import java.lang.reflect.Field;

public class EntityColumnId implements EntityColumn {

    private final EntityColumnField entityColumnField;

    public EntityColumnId(final Field field) {
        this(new EntityColumnField(field));
    }

    public EntityColumnId(final EntityColumnField entityColumnField) {
        this.entityColumnField = entityColumnField;
    }

    @Override
    public String name() {
        return entityColumnField.name();
    }

    @Override
    public boolean isSameType(Class<?> clazz) {
        return entityColumnField.isSameType(clazz);
    }

    @Override
    public boolean isAutoIncrement() {
        return entityColumnField.isAutoIncrement();
    }

    @Override
    public boolean isNullable() {
        return false;
    }

    @Override
    public boolean hasPrimaryKey() {
        return true;
    }
}
