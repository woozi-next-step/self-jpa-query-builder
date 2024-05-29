package org.woozi.pratice.jakarta.persistence.entity;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class EntityColumns {

    private final List<EntityColumn> entityColumnFields;

    public EntityColumns(final List<EntityColumn> entityColumnFields) {
        if (entityColumnFields.stream().noneMatch(EntityColumn::hasPrimaryKey)) {
            throw new RuntimeException("Id 어노테이션이 선언되지 않은 필드가 존재합니다.");
        }
        this.entityColumnFields = entityColumnFields;
    }

    public EntityColumns(final Class<?> clazz) {
        this(Arrays.stream(clazz.getDeclaredFields())
                .filter(it -> !it.isAnnotationPresent(Transient.class))
                .map(EntityColumn::of)
                .toList());
    }

    public EntityColumn primaryKey() {
        return entityColumnFields.stream().filter(EntityColumn::hasPrimaryKey)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Id 어노테이션이 선언되지 않은 필드가 존재합니다."));
    }

    public <R> Stream<R> map(Function<? super EntityColumn, ? extends R> mapper) {
        return entityColumnFields.stream().map(mapper);
    }
}
