package org.woozi.pratice.jakarta.persistence.entity.strategy.option;

import org.woozi.pratice.jakarta.persistence.entity.EntityColumn;

public class EntityColumnOptionNullableDialectStrategy implements EntityColumnOptionDialectStrategy {
    private static final String DIALECT = "NULL";

    @Override
    public boolean isAcceptable(final EntityColumn entityColumn) {
        return entityColumn.isNullable();
    }

    @Override
    public String query() {
        return DIALECT;
    }
}
