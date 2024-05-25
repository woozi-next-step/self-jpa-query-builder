package org.woozi.pratice.jakarta.persistence.entity;

import java.lang.reflect.Field;

public class EntityColumn {

    private final String name;
    private final EntityColumnType type;
    private final EntityColumnOption option;

    public EntityColumn(final Field field) {
        this(field.getName(), field.getType().getTypeName(), field.getAnnotation(Column.class));
    }

    public EntityColumn(final String name, final String type, final Column column) {
        this.name = name;
        this.type = EntityColumnType.of(type);
        this.option = EntityColumnOption.of(column);
    }

    public String getName() {
        return option.getName(name);
    }

    public String getSpec() {
        return type.getSqlType().concat(option.spec());
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
