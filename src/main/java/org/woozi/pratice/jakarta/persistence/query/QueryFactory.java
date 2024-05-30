package org.woozi.pratice.jakarta.persistence.query;

import org.woozi.pratice.jakarta.persistence.query.ddl.CreateQuery;
import org.woozi.pratice.jakarta.persistence.query.ddl.DropQuery;

import java.util.Arrays;

public enum QueryFactory {
    CREATE("create", new CreateQuery()),
    DROP("drop", new DropQuery());

    private final String type;
    private final Query query;

    QueryFactory(final String type, final Query query) {
        this.type = type;
        this.query = query;
    }

    public static Query of(final String queryType) {
        return Arrays.stream(values())
                .filter(it -> it.type.equals(queryType))
                .map(it -> it.query)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public String type() {
        return type;
    }
}
