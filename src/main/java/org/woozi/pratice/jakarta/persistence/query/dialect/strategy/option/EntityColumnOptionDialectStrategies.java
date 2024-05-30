package org.woozi.pratice.jakarta.persistence.query.dialect.strategy.option;

import org.woozi.pratice.jakarta.persistence.entity.annotation.EntityColumn;

import java.util.List;
import java.util.stream.Collectors;

public class EntityColumnOptionDialectStrategies {
    private static final List<EntityColumnOptionDialectStrategy> STRATEGIES = List.of(
            new EntityColumnOptionNullableDialectStrategy(),
            new EntityColumnOptionNotNullableDialectStrategy(),
            new EntityColumnOptionAutoIncrementDialectStrategy()
    );

    public static String execute(final EntityColumn column) {
        return STRATEGIES.stream()
                .filter(it -> it.isAcceptable(column))
                .map(EntityColumnOptionDialectStrategy::query)
                .collect(Collectors.joining(" "));
    }
}
