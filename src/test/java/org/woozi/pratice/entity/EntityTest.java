package org.woozi.pratice.entity;

import org.junit.jupiter.api.Test;
import org.woozi.pratice.jakarta.persistence.Entity;
import org.woozi.pratice.jakarta.persistence.Id;
import org.woozi.pratice.jakarta.persistence.QueryBuilder;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;


class EntityTest {

    @Test
    void Entity_어노테이션_선언_클래스_create_쿼리를_생성한다() {
        // when
        final String actual = QueryBuilder.create(Person.class);

        // then
        final String expected = "CREATE TABLE `person` ('id' bigint, 'name' varchar(255), 'age' int, PRIMARY KEY (`id`));";

        assertThat(actual).isEqualTo(expected);
    }


    @Entity
    class TestEntity {
        @Id
        private Long id;

        private String name;

        private Integer age;

        public TestEntity() {
        }

        public TestEntity(final Long id, final String name, final Integer age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final TestEntity that = (TestEntity) o;
            return Objects.equals(getId(), that.getId());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId());
        }
    }
}