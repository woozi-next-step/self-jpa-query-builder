package org.woozi.pratice.jakarta.persistence.entity;

import java.util.Objects;

public class EntityColumnOption {
    private final String name;
    private final boolean nullable;
    private final GenerationType generationType;

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

    public String getName() {
        return this.name;
    }

    public boolean isNullable() {
        return nullable;
    }

    public boolean isAutoIncrement() {
        return generationType.equals(GenerationType.IDENTITY);
    }
}
