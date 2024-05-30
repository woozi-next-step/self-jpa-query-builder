package org.woozi.pratice.jakarta.persistence.query.ddl;

import org.woozi.pratice.jakarta.persistence.entity.EntityClass;
import org.woozi.pratice.jakarta.persistence.query.dialect.Dialect;

public class DropQuery implements DDL {

    private static final String DROP_TABLE_QUERY = "DROP TABLE `%s`;";

    public String execute(final EntityClass entityClass, final Dialect dialect) {
        return String.format(DROP_TABLE_QUERY, entityClass.name().name());
    }
}
