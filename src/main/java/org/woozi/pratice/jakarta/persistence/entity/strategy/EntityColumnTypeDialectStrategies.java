package org.woozi.pratice.jakarta.persistence.entity.strategy;

import org.woozi.pratice.jakarta.persistence.entity.EntityColumnType;

import java.util.List;

public class EntityColumnTypeDialectStrategies {

    private static final List<EntityColumnTypeDialectStrategy> strategies = List.of(
            new EntityColumnTypeStringDialectStrategy(),
            new EntityColumnTypeIntegerDialectStrategy(),
            new EntityColumnTypeLongDialectStrategy()
    );

    public static String execute(final EntityColumnType type) {
        final EntityColumnTypeDialectStrategy entityColumnTypeDialectStrategy = find(type);
        return entityColumnTypeDialectStrategy.query();
    }

    public static EntityColumnTypeDialectStrategy find(final EntityColumnType entityColumnType) {
        return strategies.stream().filter(strategy -> strategy.isJavaType(entityColumnType.javaType()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unsupported java type: " + entityColumnType.javaType()));
    }
}