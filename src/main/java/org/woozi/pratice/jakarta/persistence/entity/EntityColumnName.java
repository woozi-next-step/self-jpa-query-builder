package org.woozi.pratice.jakarta.persistence.entity;

import java.lang.reflect.Field;

public class EntityColumnName {
    private final String name;

    public EntityColumnName(final Field filed) {
        this(filed.getName());
    }

    public EntityColumnName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
