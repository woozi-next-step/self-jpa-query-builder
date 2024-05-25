package org.woozi.pratice.jakarta.persistence.entity;

import java.util.Objects;

public class EntityColumnOption {
    private final String name;
    private final boolean nullable;

    public EntityColumnOption(final Column column) {
        this(column.name(), column.nullable());
    }

    public EntityColumnOption(final String name, final boolean nullable) {
        this.name = name;
        this.nullable = nullable;
    }

    public static EntityColumnOption of(final Column column) {
        if(Objects.isNull(column)) {
            return new EntityColumnOption("", false);
        }
        return new EntityColumnOption(column.name(), column.nullable());
    }

    public String getName(final String name) {
        return this.name.isBlank() ? name : this.name;
    }

    public String spec() {
        return nullable ? " NULL" : " NOT NULL";
    }
}
