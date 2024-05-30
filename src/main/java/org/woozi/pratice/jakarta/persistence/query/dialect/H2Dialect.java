package org.woozi.pratice.jakarta.persistence.query.dialect;

import org.woozi.pratice.jakarta.persistence.entity.annotation.EntityColumn;
import org.woozi.pratice.jakarta.persistence.query.dialect.strategy.option.EntityColumnOptionDialectStrategies;
import org.woozi.pratice.jakarta.persistence.query.dialect.strategy.type.EntityColumnTypeDialectStrategies;

public class H2Dialect implements Dialect {
    private static final String DELIMITER = " ";

    @Override
    public String execute(final EntityColumn column) {
        final String type = EntityColumnTypeDialectStrategies.execute(column);
        return type.concat(DELIMITER).concat(EntityColumnOptionDialectStrategies.execute(column));
    }
}
