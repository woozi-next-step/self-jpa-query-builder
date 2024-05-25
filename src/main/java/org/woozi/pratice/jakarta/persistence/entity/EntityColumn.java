package org.woozi.pratice.jakarta.persistence.entity;

import java.lang.reflect.Field;

public class EntityColumn {

    private final String name;
    private final EntityColumnType type;

    public EntityColumn(final String name, final String type) {
        this.name = name;
        this.type = EntityColumnType.of(type);
    }

    public EntityColumn(final Field field) {
        this(field.getName(), field.getType().getTypeName());
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type.getSqlType();
    }

    public boolean hasPrimaryKey() {
        return false;
    }

    public static EntityColumn of(final Field field) {
        if (field.isAnnotationPresent(Id.class)) {
            return new EntityIdColumn(field);
        }
        return new EntityColumn(field);
    }
}
