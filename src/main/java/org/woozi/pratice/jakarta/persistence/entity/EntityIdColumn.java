package org.woozi.pratice.jakarta.persistence.entity;

import java.lang.reflect.Field;

public class EntityIdColumn extends EntityColumn {

    public EntityIdColumn(final String name, final String type) {
        super(name, type);
    }

    public EntityIdColumn(final Field field) {
        this(field.getName(), field.getType().getTypeName());
    }

    public boolean hasPrimaryKey() {
        return true;
    }
}
