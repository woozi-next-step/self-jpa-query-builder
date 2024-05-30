package org.woozi.pratice.jakarta.persistence.query.dialect.strategy.type;

import org.woozi.pratice.jakarta.persistence.entity.annotation.EntityColumn;

public class EntityColumnTypeIntegerDialectStrategy implements EntityColumnTypeDialectStrategy {
    private static final Class<?> JAVA_TYPE = Integer.class;
    private static final String DIALECT = "INT";

    @Override
    public boolean isAcceptable(final EntityColumn entityColumn) {
        return entityColumn.isSameType(JAVA_TYPE);
    }

    @Override
    public String query() {
        return DIALECT;
    }
}
