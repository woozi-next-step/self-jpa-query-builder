package org.woozi.pratice.jakarta.persistence.entity.strategy.option;

import org.woozi.pratice.jakarta.persistence.entity.EntityColumn;

public interface EntityColumnOptionDialectStrategy {
    boolean isAcceptable(final EntityColumn entityColumn);
    String query();
}
