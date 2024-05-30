package org.woozi.pratice.jakarta.persistence.query.dialect.strategy.option;

import org.woozi.pratice.jakarta.persistence.entity.annotation.EntityColumn;

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
