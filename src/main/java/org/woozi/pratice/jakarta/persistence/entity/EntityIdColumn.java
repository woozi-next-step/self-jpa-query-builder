package org.woozi.pratice.jakarta.persistence.entity;

import java.lang.reflect.Field;

public class EntityIdColumn extends EntityColumn {

    public EntityIdColumn(final String name, final String type, final Column column) {
        super(name, type, column);
    }

    public EntityIdColumn(final Field field) {
        this(field.getName(), field.getType().getTypeName(), field.getAnnotation(Column.class));
    }

    public boolean hasPrimaryKey() {
        return true;
    }
}
