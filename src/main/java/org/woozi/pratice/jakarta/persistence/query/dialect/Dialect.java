package org.woozi.pratice.jakarta.persistence.query.dialect;

import org.woozi.pratice.jakarta.persistence.entity.annotation.EntityColumn;

public interface Dialect {
    String execute(EntityColumn column);
}
