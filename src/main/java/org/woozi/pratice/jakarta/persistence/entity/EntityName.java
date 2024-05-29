package org.woozi.pratice.jakarta.persistence.entity;

public class EntityName {

    private final String name;

    public EntityName(final Class<?> clazz) {
        this.name = name(clazz);
    }

    private String name(final Class<?> clazz) {
        if (!clazz.isAnnotationPresent(Table.class) || clazz.getAnnotation(Table.class).name().isEmpty()) {
            return clazz.getSimpleName().toLowerCase();
        }
        return clazz.getAnnotation(Table.class).name();
    }

    public String name() {
        return name;
    }
}
