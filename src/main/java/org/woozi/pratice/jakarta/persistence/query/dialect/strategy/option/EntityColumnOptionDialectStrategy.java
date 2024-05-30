package org.woozi.pratice.jakarta.persistence.query.dialect.strategy.option;

import org.woozi.pratice.jakarta.persistence.entity.annotation.EntityColumn;

public interface EntityColumnOptionDialectStrategy {
    boolean isAcceptable(final EntityColumn entityColumn);
    String query();
}
