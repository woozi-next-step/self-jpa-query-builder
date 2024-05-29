package org.woozi.pratice.jakarta.persistence.entity.strategy;

import org.woozi.pratice.jakarta.persistence.entity.EntityColumn;

public class EntityColumnTypeLongDialectStrategy implements EntityColumnTypeDialectStrategy {
    private static final Class<?> JAVA_TYPE = Long.class;
    private static final String DIALECT = "BIGINT";

    @Override
    public boolean isAcceptable(final EntityColumn entityColumn) {
        return entityColumn.isSameType(JAVA_TYPE);
    }

    @Override
    public String query() {
        return DIALECT;
    }
}
