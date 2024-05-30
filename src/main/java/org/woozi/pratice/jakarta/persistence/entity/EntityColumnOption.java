package org.woozi.pratice.jakarta.persistence.entity;

import org.woozi.pratice.jakarta.persistence.entity.annotation.Column;
import org.woozi.pratice.jakarta.persistence.entity.annotation.GeneratedValue;

import java.lang.reflect.Field;
import java.util.Objects;

public class EntityColumnOption {
    private final String name;
    private final boolean nullable;
    private final GenerationType generationType;

    public EntityColumnOption(final Field field) {
        this(field.getAnnotation(Column.class), field.getAnnotation(GeneratedValue.class));
    }

    private static boolean getNullable(final Column column) {
        if(Objects.isNull(column)) {
            return true;
        }
        return column.nullable();
    }

    private static String getName(final Column column) {
        if(Objects.isNull(column)) {
            return "";
        }
        return column.name();
    }

    private static GenerationType getStrategy(final GeneratedValue generatedValue) {
        if (Objects.isNull(generatedValue)) {
            return GenerationType.NONE;
        }
        return generatedValue.strategy();
    }

    public EntityColumnOption(final Column column, final GeneratedValue generatedValue) {
        this(getName(column), getNullable(column), getStrategy(generatedValue));
    }

    public EntityColumnOption(final String name, final boolean nullable, final GenerationType generationType) {
        this.name = name;
        this.nullable = nullable;
        this.generationType = generationType;
    }

    public String getName(final EntityColumnName name) {
        return this.name.isBlank() ? name.getName() : this.name;
    }

    public boolean isNullable() {
        return nullable;
    }

    public boolean isAutoIncrement() {
        return generationType.equals(GenerationType.IDENTITY) || generationType.equals(GenerationType.AUTO);
    }
}
