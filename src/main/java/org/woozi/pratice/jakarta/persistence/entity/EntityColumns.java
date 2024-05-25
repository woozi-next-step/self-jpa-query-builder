package org.woozi.pratice.jakarta.persistence.entity;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class EntityColumns {

    private final List<EntityColumn> entityColumns;

    public EntityColumns(final List<EntityColumn> entityColumns) {
        if (entityColumns.stream().noneMatch(EntityColumn::hasPrimaryKey)) {
            throw new RuntimeException("Id 어노테이션이 선언되지 않은 필드가 존재합니다.");
        }
        this.entityColumns = entityColumns;
    }

    public EntityColumns(final Class<?> clazz) {
        this(Arrays.stream(clazz.getDeclaredFields())
                .map(EntityColumn::of)
                .toList());
    }

    public EntityColumn primaryKey() {
        return entityColumns.stream().filter(EntityColumn::hasPrimaryKey)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Id 어노테이션이 선언되지 않은 필드가 존재합니다."));
    }

    public <R> Stream<R> map(Function<? super EntityColumn, ? extends R> mapper) {
        return entityColumns.stream().map(mapper);
    }
}
