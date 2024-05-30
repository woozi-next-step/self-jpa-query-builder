package org.woozi.pratice.jakarta.persistence.query.dialect.strategy.type;

import org.woozi.pratice.jakarta.persistence.entity.annotation.EntityColumn;

import java.util.List;

public class EntityColumnTypeDialectStrategies {

    private static final List<EntityColumnTypeDialectStrategy> strategies = List.of(
            new EntityColumnTypeStringDialectStrategy(),
            new EntityColumnTypeIntegerDialectStrategy(),
            new EntityColumnTypeLongDialectStrategy()
    );

    public static String execute(final EntityColumn entityColumn) {
        final EntityColumnTypeDialectStrategy entityColumnTypeDialectStrategy = strategy(entityColumn);
        return entityColumnTypeDialectStrategy.query();
    }

    public static EntityColumnTypeDialectStrategy strategy(final EntityColumn entityColumn) {
        return strategies.stream().filter(strategy -> strategy.isAcceptable(entityColumn))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unsupported java type"));
    }
}