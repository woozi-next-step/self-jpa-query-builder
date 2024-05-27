package org.woozi.pratice.jakarta.persistence.query.ddl;

import org.woozi.pratice.jakarta.persistence.entity.EntityClass;
import org.woozi.pratice.jakarta.persistence.entity.EntityColumn;
import org.woozi.pratice.jakarta.persistence.entity.strategy.EntityColumnTypeDialectStrategies;
import org.woozi.pratice.jakarta.persistence.entity.strategy.option.EntityColumnOptionDialectStrategies;

import java.util.stream.Collectors;

public class CreateQuery implements DDL {

    private static final String CREATE_TABLE_QUERY = "CREATE TABLE `%s` (%s);";
    private static final String TABLE_COLUMN_SPEC = "`%s` %s";
    private static final String PRIMARY_KEY = "PRIMARY KEY(`%s`)";
    private static final String SPEC_DELIMITER = ", ";
    private static final String DELIMITER = " ";

    // 쿼리를 만들어줘
    public String execute(EntityClass entityClass) {
        return String.format(CREATE_TABLE_QUERY, entityClass.tableName(), columns(entityClass));
    }

    // 컬럼 스펙을 만들어줘
    // 컬럼명과 컬럼타입을 받아서 컬럼 스펙을 만들어줘
    private String columns(final EntityClass entityClass) {
        return entityClass.columns()
                .map(CreateQuery::columnFiled)
                .collect(Collectors.joining(SPEC_DELIMITER))
                .concat(SPEC_DELIMITER)
                .concat(primaryKey(entityClass));
    }

    private static String columnFiled(final EntityColumn column) {
        final String name = column.name();
        return String.format(TABLE_COLUMN_SPEC, name, dialect(column));
    }

    private static String dialect(final EntityColumn column) {
        final String type = EntityColumnTypeDialectStrategies.execute(column.type());
        return type.concat(DELIMITER).concat(EntityColumnOptionDialectStrategies.execute(column));
    }

    private String primaryKey(final EntityClass entityClass) {
        return PRIMARY_KEY.formatted(entityClass.primaryKey().name());
    }
}
