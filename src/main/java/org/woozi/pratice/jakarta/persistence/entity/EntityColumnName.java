package org.woozi.pratice.jakarta.persistence.entity;

public class EntityColumnName {
    private final String name;

    public EntityColumnName(final String name) {
        this.name = name;
    }

    public String getName(final EntityColumnOption option) {
        return name.isBlank() ? option.getName() : name;
    }
}
