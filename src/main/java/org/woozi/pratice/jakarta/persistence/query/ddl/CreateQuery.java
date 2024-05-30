package org.woozi.pratice.jakarta.persistence.query.ddl;

import org.woozi.pratice.jakarta.persistence.entity.EntityClass;
import org.woozi.pratice.jakarta.persistence.entity.annotation.EntityColumn;
import org.woozi.pratice.jakarta.persistence.query.dialect.Dialect;

import java.util.stream.Collectors;

public class CreateQuery implements DDL {

    private static final String CREATE_TABLE_QUERY = "CREATE TABLE `%s` (%s);";
    private static final String TABLE_COLUMN_SPEC = "`%s` %s";
    private static final String PRIMARY_KEY = "PRIMARY KEY(`%s`)";
    private static final String SPEC_DELIMITER = ", ";

    public String execute(final EntityClass entityClass, final Dialect dialect) {
        return String.format(CREATE_TABLE_QUERY, entityClass.name().name(), columns(entityClass, dialect));
    }

    private String columns(final EntityClass entityClass, final Dialect dialect) {
        return entityClass.columns()
                .map(it -> columnFiled(it, dialect))
                .collect(Collectors.joining(SPEC_DELIMITER))
                .concat(SPEC_DELIMITER)
                .concat(primaryKey(entityClass));
    }

    private static String columnFiled(final EntityColumn column, final Dialect dialect) {
        final String name = column.name();
        return String.format(TABLE_COLUMN_SPEC, name, dialect.execute(column));
    }

    private String primaryKey(final EntityClass entityClass) {
        return PRIMARY_KEY.formatted(entityClass.primaryKey().name());
    }
}
