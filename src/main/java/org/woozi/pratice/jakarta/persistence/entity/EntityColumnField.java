package org.woozi.pratice.jakarta.persistence.entity;

import org.woozi.pratice.jakarta.persistence.entity.annotation.EntityColumn;

import java.lang.reflect.Field;

public class EntityColumnField implements EntityColumn {

    private final EntityColumnName name;
    private final EntityColumnType type;
    private final EntityColumnOption option;

    public EntityColumnField(final Field field) {
        this.name = new EntityColumnName(field);
        this.type = new EntityColumnType(field);
        this.option = new EntityColumnOption(field);
    }

    @Override
    public String name() {
        return option.getName(name);
    }

    @Override
    public boolean isSameType(final Class<?> javaType) {
        return type.isSameType(javaType);
    }

    @Override
    public boolean isAutoIncrement() {
        return option.isAutoIncrement();
    }

    @Override
    public boolean isNullable() {
        return option.isNullable();
    }

    @Override
    public boolean hasPrimaryKey() {
        return false;
    }
}
