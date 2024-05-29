package org.woozi.pratice.jakarta.persistence.entity.strategy;

import org.woozi.pratice.jakarta.persistence.entity.EntityColumn;

public interface EntityColumnTypeDialectStrategy {
    boolean isAcceptable(EntityColumn entityColumn);

    String query();
}
