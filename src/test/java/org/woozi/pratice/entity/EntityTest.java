package org.woozi.pratice.entity;

import org.junit.jupiter.api.Test;
import org.woozi.pratice.jakarta.persistence.query.QueryBuilder;

import static org.assertj.core.api.Assertions.assertThat;


class EntityTest {

    @Test
    void Entity_어노테이션_선언_클래스_create_쿼리를_생성한다() {
        // when
        final String actual = QueryBuilder.execute(Person.class, "create");

        // then
        final String expected = "CREATE TABLE `person` (`id` BIGINT NOT NULL AUTO_INCREMENT, `name` VARCHAR(255) NOT NULL, `age` INT NOT NULL, `email` VARCHAR(255) NOT NULL, PRIMARY KEY(`id`));";

        assertThat(actual).isEqualTo(expected);
    }
}