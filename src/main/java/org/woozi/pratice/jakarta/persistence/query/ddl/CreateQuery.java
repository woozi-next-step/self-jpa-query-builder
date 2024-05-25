package org.woozi.pratice.jakarta.persistence.query.ddl;

import org.woozi.pratice.jakarta.persistence.entity.EntityClass;

import java.util.stream.Collectors;

public class CreateQuery implements DDL {

    private static final String CREATE_TABLE_QUERY = "CREATE TABLE `%s` (%s);";
    private static final String TABLE_COLUMN_SPEC = "`%s` %s";
    private static final String PRIMARY_KEY = "PRIMARY KEY(`%s`)";
    private static final String SPEC_DELIMITER = ", ";

    public String execute(EntityClass entityClass) {
        return String.format(CREATE_TABLE_QUERY, entityClass.tableName(), columnSpec(entityClass));
    }

    private String columnSpec(final EntityClass entityClass) {
        return entityClass.columns()
                .map(column -> String.format(TABLE_COLUMN_SPEC, column.getName(), column.getSpec()))
                .collect(Collectors.joining(SPEC_DELIMITER))
                .concat(SPEC_DELIMITER)
                .concat(primaryKeySpec(entityClass));
    }

    private String primaryKeySpec(final EntityClass entityClass) {
        return PRIMARY_KEY.formatted(entityClass.primaryKey().getName());
    }
}
