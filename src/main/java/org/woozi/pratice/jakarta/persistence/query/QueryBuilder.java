package org.woozi.pratice.jakarta.persistence.query;

import org.woozi.pratice.jakarta.persistence.entity.EntityClass;

public class QueryBuilder {
    // 쿼리를 만들어줘
    public static String execute(final Class<?> clazz, final String command) {
        final Query query = QueryFactory.of(command);
        return query.execute(new EntityClass(clazz));
    }
}

