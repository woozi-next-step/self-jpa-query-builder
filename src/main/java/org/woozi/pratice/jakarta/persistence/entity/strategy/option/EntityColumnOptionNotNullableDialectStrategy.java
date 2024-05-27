package org.woozi.pratice.jakarta.persistence.entity.strategy.option;

import org.woozi.pratice.jakarta.persistence.entity.EntityColumn;

public class EntityColumnOptionNotNullableDialectStrategy implements EntityColumnOptionDialectStrategy {
    private static final String DIALECT = "NOT NULL";

    @Override
    public boolean isAcceptable(final EntityColumn entityColumn) {
        return !entityColumn.option().isNullable();
    }

    @Override
    public String query() {
        return DIALECT;
    }
}
