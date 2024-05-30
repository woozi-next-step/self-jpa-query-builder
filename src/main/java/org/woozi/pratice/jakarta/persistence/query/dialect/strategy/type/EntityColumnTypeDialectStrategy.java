package org.woozi.pratice.jakarta.persistence.query.dialect.strategy.type;

import org.woozi.pratice.jakarta.persistence.entity.annotation.EntityColumn;

public interface EntityColumnTypeDialectStrategy {
    boolean isAcceptable(EntityColumn entityColumn);

    String query();
}
