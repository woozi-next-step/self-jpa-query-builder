package org.woozi.pratice.entity;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.woozi.pratice.jakarta.persistence.entity.annotation.Entity;
import org.woozi.pratice.jakarta.persistence.entity.annotation.Id;
import org.woozi.pratice.jakarta.persistence.query.dialect.H2Dialect;
import org.woozi.pratice.jakarta.persistence.query.QueryBuilder;
import org.woozi.pratice.jakarta.persistence.query.QueryFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class EntityTest {

    @Test
    void Entity_어노테이션_선언_클래스_create_쿼리를_생성한다() {
        // when
        final QueryBuilder queryBuilder = new QueryBuilder(new H2Dialect());
        final String actual = queryBuilder.execute(Person.class, QueryFactory.CREATE.type());

        // then
        final String expected = "CREATE TABLE `persons` (`id` BIGINT NOT NULL AUTO_INCREMENT, `nick_name` VARCHAR(255) NULL, `old` INT NULL, `email` VARCHAR(255) NOT NULL, PRIMARY KEY(`id`));";

        assertThat(actual).isEqualTo(expected);
    }

    @Nested
    class Id_어노테이션_단위_테스트 {
        @Entity
        private class NoIdClass {
            private Long id;
        }

        @Entity
        private class TwoIdClass {
            @Id
            private Long id;

            @Id
            private Long secondId;
        }


        @Test
        void ID_어노테이션이_존재하지_않는다면_에러를_뱉는다() {
            final QueryBuilder queryBuilder = new QueryBuilder(new H2Dialect());

            assertThatThrownBy(() -> queryBuilder.execute(NoIdClass.class, QueryFactory.CREATE.type()))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Id 어노테이션이 선언되지 않은 필드가 존재합니다.");
        }

        @Test
        void ID_어노테이션이_2개_이상_존재하면_에러를_뱉는다() {
            final QueryBuilder queryBuilder = new QueryBuilder(new H2Dialect());

            assertThatThrownBy(() -> queryBuilder.execute(TwoIdClass.class, QueryFactory.CREATE.type()))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("Id 어노테이션이 선언된 필드는 하나만 존재해야 합니다.");
        }
    }
}
