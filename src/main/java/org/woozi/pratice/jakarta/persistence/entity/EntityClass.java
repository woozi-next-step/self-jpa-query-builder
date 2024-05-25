package org.woozi.pratice.jakarta.persistence.entity;

public class EntityClass {

    private final String tableName;
    private final EntityColumns entityColumns;

    public EntityClass(final Class<?> clazz) {
        if (!clazz.isAnnotationPresent(Entity.class)) {
            throw new RuntimeException("Entity 어노테이션이 선언되지 않은 클래스입니다.");
        }
        this.tableName = clazz.getSimpleName().toLowerCase();
        this.entityColumns = new EntityColumns(clazz);
    }

    public String tableName() {
        return tableName;
    }

    public EntityColumns columns() {
        return entityColumns;
    }

    public EntityColumn primaryKey() {
        return entityColumns.primaryKey();
    }
}