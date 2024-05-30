package org.woozi.pratice.jakarta.persistence.query;

import org.woozi.pratice.jakarta.persistence.entity.EntityClass;
import org.woozi.pratice.jakarta.persistence.query.dialect.Dialect;

public class QueryBuilder {
    private final Dialect dialect;

    public QueryBuilder(final Dialect dialect) {
        this.dialect = dialect;
    }

    public String execute(final Class<?> clazz, final String command) {
        final Query query = QueryFactory.of(command);
        return query.execute(new EntityClass(clazz), dialect);
    }
}

