package org.woozi.pratice.jakarta.persistence.query;

import org.woozi.pratice.jakarta.persistence.entity.EntityClass;
import org.woozi.pratice.jakarta.persistence.query.dialect.Dialect;

public interface Query {
    String execute(final EntityClass entityClass, final Dialect dialect);
}
