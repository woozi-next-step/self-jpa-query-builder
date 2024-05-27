package org.woozi.pratice.jakarta.persistence.entity.strategy.option;

import org.woozi.pratice.jakarta.persistence.entity.EntityColumn;

import java.util.List;
import java.util.stream.Collectors;

public class EntityColumnOptionDialectStrategies {
    private static final List<EntityColumnOptionDialectStrategy> STRATEGIES = List.of(
            new EntityColumnOptionNotNullableDialectStrategy(),
            new EntityColumnOptionAutoIncrementDialectStrategy(),
            new EntityColumnOptionNullableDialectStrategy()
    );

    public static String execute(final EntityColumn column) {
        return STRATEGIES.stream()
                .filter(it -> it.isAcceptable(column))
                .map(EntityColumnOptionDialectStrategy::query)
                .collect(Collectors.joining(" "));
    }
}