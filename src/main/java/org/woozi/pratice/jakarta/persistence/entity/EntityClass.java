package org.woozi.pratice.jakarta.persistence.entity;

public class EntityClass {

    private final EntityName name;
    private final EntityColumns entityColumns;

    public EntityClass(final Class<?> clazz) {
        if (!clazz.isAnnotationPresent(Entity.class)) {
            throw new RuntimeException("Entity 어노테이션이 선언되지 않은 클래스입니다.");
        }
        this.name = new EntityName(clazz);
        this.entityColumns = new EntityColumns(clazz);
    }

    public EntityName name() {
        return name;
    }

    public EntityColumns columns() {
        return entityColumns;
    }

    public EntityColumn primaryKey() {
        return entityColumns.primaryKey();
    }
}
