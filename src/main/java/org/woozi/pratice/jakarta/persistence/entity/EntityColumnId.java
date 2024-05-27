package org.woozi.pratice.jakarta.persistence.entity;

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
    public EntityColumnType type() {
        return entityColumnField.type();
    }

    @Override
    public EntityColumnOption option() {
        return entityColumnField.option();
    }

    @Override
    public boolean hasPrimaryKey() {
        return true;
    }
}
