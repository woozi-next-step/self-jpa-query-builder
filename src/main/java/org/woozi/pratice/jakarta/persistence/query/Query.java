package org.woozi.pratice.jakarta.persistence.query;

import org.woozi.pratice.jakarta.persistence.entity.EntityClass;

public interface Query {
    String execute(EntityClass entityClass);
}
