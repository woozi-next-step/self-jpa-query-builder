package org.woozi.pratice.jakarta.persistence.entity;

import java.lang.reflect.Field;

public class EntityColumnField implements EntityColumn {

    private final EntityColumnName name;
    private final EntityColumnType type;
    private final EntityColumnOption option;

    public EntityColumnField(final Field field) {
        this(field.getName(), field.getType(), field.getAnnotation(Column.class), field.getAnnotation(GeneratedValue.class));
    }

    public EntityColumnField(final String name, final Class<?> type, final Column column, final GeneratedValue generatedValue) {
        this.name = new EntityColumnName(name);
        this.type = new EntityColumnType(type);
        this.option = new EntityColumnOption(column, generatedValue);
    }

    public String name() {
        return name.getName(option);
    }

    public EntityColumnType type() {
        return type;
    }

    public EntityColumnOption option() {
        return option;
    }

    public boolean hasPrimaryKey() {
        return false;
    }
}