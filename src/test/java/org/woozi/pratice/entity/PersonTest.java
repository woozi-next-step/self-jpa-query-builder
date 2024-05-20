package org.woozi.pratice.entity;

import org.junit.jupiter.api.Test;
import org.woozi.pratice.jakarta.persistence.QueryBuilder;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

    @Test
    void Entity_어노테이션_선언_클래스_create_쿼리를_생성한다() {
        // given
        final Person person = new Person(1L, "Woozi", 27);

        // when
        final String query = QueryBuilder.create(person);

        // then
        assertThat("INSERT INTO PERSON (ID, NAME, AGE) VALUES (1, 'Woozi', 27)").isEqualTo(query);
    }
}