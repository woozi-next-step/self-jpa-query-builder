package org.woozi.pratice.jakarta.persistence.entity.strategy;

import org.woozi.pratice.jakarta.persistence.entity.EntityColumn;

public class EntityColumnTypeStringDialectStrategy implements EntityColumnTypeDialectStrategy {
    private static final Class<?> JAVA_TYPE = String.class;
    private static final String DIALECT = "VARCHAR(255)";

    @Override
    public boolean isAcceptable(final EntityColumn entityColumn) {
        return entityColumn.isSameType(JAVA_TYPE);
    }

    @Override
    public String query() {
        return DIALECT;
    }
}
