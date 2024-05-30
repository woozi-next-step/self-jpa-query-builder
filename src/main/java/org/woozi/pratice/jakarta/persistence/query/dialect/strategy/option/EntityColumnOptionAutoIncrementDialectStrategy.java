package org.woozi.pratice.jakarta.persistence.query.dialect.strategy.option;

import org.woozi.pratice.jakarta.persistence.entity.annotation.EntityColumn;

public class EntityColumnOptionAutoIncrementDialectStrategy implements EntityColumnOptionDialectStrategy {
    private static final String DIALECT = "AUTO_INCREMENT";

    @Override
    public boolean isAcceptable(final EntityColumn entityColumn) {
        return entityColumn.hasPrimaryKey() && entityColumn.isAutoIncrement();
    }

    @Override
    public String query() {
        return DIALECT;
    }
}
