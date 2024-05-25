package org.woozi.pratice.jakarta.persistence.query;

import org.woozi.pratice.jakarta.persistence.entity.EntityClass;

public class QueryBuilder {
    public static String execute(final Class<?> clazz, final String command) {
        final Query query = QueryFactory.query(command);
        return query.execute(new EntityClass(clazz));
    }
}

