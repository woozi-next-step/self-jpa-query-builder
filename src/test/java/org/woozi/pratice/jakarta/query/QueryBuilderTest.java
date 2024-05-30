package org.woozi.pratice.jakarta.query;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.woozi.pratice.entity.PersonV1;
import org.woozi.pratice.entity.PersonV2;
import org.woozi.pratice.entity.PersonV3;
import org.woozi.pratice.jakarta.persistence.entity.GenerationType;
import org.woozi.pratice.jakarta.persistence.entity.annotation.*;
import org.woozi.pratice.jakarta.persistence.query.dialect.H2Dialect;
import org.woozi.pratice.jakarta.persistence.query.QueryBuilder;
import org.woozi.pratice.jakarta.persistence.query.QueryFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("QueryBuilder 단위 테스트")
class QueryBuilderTest {

    @DisplayName("QueryBuilder 요구사항 테스트")
    @Nested
    class QueryBuilder_요구사항_테스트 {

        @DisplayName("Entity 어노테이션 선언 클래스 create 쿼리를 생성한다 v1")
        @Test
        void Entity_어노테이션_선언_클래스_create_쿼리를_생성한다_v1() {
            final QueryBuilder queryBuilder = new QueryBuilder(new H2Dialect());
            final String actual = queryBuilder.execute(PersonV1.class, QueryFactory.CREATE.type());

            final String expected = "CREATE TABLE `personv1` (`id` BIGINT NOT NULL, `name` VARCHAR(255) NULL, `age` INT NULL, PRIMARY KEY(`id`));";

            assertThat(actual).isEqualTo(expected);
        }

        @DisplayName("Entity 어노테이션 선언 클래스 create 쿼리를 생성한다 v2")
        @Test
        void Entity_어노테이션_선언_클래스_create_쿼리를_생성한다_v2() {
            final QueryBuilder queryBuilder = new QueryBuilder(new H2Dialect());
            final String actual = queryBuilder.execute(PersonV2.class, QueryFactory.CREATE.type());

            final String expected = "CREATE TABLE `personv2` (`id` BIGINT NOT NULL AUTO_INCREMENT, `nick_name` VARCHAR(255) NULL, `old` INT NULL, `email` VARCHAR(255) NOT NULL, PRIMARY KEY(`id`));";

            assertThat(actual).isEqualTo(expected);
        }

        @DisplayName("Entity 어노테이션 선언 클래스 create 쿼리를 생성한다 v3")
        @Test
        void Entity_어노테이션_선언_클래스_create_쿼리를_생성한다_v3() {
            final QueryBuilder queryBuilder = new QueryBuilder(new H2Dialect());
            final String actual = queryBuilder.execute(PersonV3.class, QueryFactory.CREATE.type());

            final String expected = "CREATE TABLE `users` (`id` BIGINT NOT NULL AUTO_INCREMENT, `nick_name` VARCHAR(255) NULL, `old` INT NULL, `email` VARCHAR(255) NOT NULL, PRIMARY KEY(`id`));";

            assertThat(actual).isEqualTo(expected);
        }

        @DisplayName("Entity 어노테이션 선언 클래스 drop 쿼리를 생성한다")
        @Test
        void Entity_어노테이션_선언_클래스_drop_쿼리를_생성한다() {
            final QueryBuilder queryBuilder = new QueryBuilder(new H2Dialect());
            final String actual = queryBuilder.execute(PersonV3.class, QueryFactory.DROP.type());

            final String expected = "DROP TABLE `users`;";

            assertThat(actual).isEqualTo(expected);
        }
    }

    @DisplayName("Entity 어노테이션 단위 테스트")
    @Nested
    class Entity_어노테이션_단위_테스트 {
        private class NoEntityClass {
            @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;
        }

        @DisplayName("Entity 어노테이션이 존재하지 않는다면 예외를 던진다")
        @Test
        void Entity_어노테이션이_존재하지_않는다면_예외를_던진다() {
            final QueryBuilder queryBuilder = new QueryBuilder(new H2Dialect());

            assertThatThrownBy(() -> queryBuilder.execute(NoEntityClass.class, QueryFactory.CREATE.type()))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Entity 어노테이션이 선언되지 않은 클래스입니다.");
        }
    }

    @DisplayName("Id 어노테이션 단위 테스트")
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

        @Entity
        private class IdWithNullableClass {
            @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(nullable = true)
            private Long id;
        }

        @Entity
        private class IdWithTransientClass {
            @Transient
            @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;
        }

        @DisplayName("ID 어노테이션이 존재하지 않는다면 예외를 던진다")
        @Test
        void ID_어노테이션이_존재하지_않는다면_예외를_던진다() {
            final QueryBuilder queryBuilder = new QueryBuilder(new H2Dialect());

            assertThatThrownBy(() -> queryBuilder.execute(NoIdClass.class, QueryFactory.CREATE.type()))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Id 어노테이션이 선언되지 않은 필드가 존재합니다.");
        }

        @DisplayName("ID 어노테이션이 2개 이상 존재하면 예외를 던진다")
        @Test
        void ID_어노테이션이_2개_이상_존재하면_예외를_던진다() {
            final QueryBuilder queryBuilder = new QueryBuilder(new H2Dialect());

            assertThatThrownBy(() -> queryBuilder.execute(TwoIdClass.class, QueryFactory.CREATE.type()))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("Id 어노테이션이 선언된 필드는 하나만 존재해야 합니다.");
        }

        @DisplayName("ID 어노테이션 컬럼에 Transient 어노테이션이 있으면 예외를 던진다")
        @Test
        void ID_어노테이션_컬럼에_Column_어노테이션_Nullable_속성이_있어도_NOT_NULL_옵션을_가진다() {
            final QueryBuilder queryBuilder = new QueryBuilder(new H2Dialect());

            final String actual = queryBuilder.execute(IdWithNullableClass.class, QueryFactory.CREATE.type());

            assertThat(actual).isEqualTo("CREATE TABLE `idwithnullableclass` (`id` BIGINT NOT NULL AUTO_INCREMENT, PRIMARY KEY(`id`));");
        }

        @DisplayName("ID 어노테이션 컬럼에 Transient 어노테이션이 있으면 예외를_던진다")
        @Test
        void ID_어노테이션_컬럼에_Transient_어노테이션이_있으면_예외를_던진다() {
            final QueryBuilder queryBuilder = new QueryBuilder(new H2Dialect());

            assertThatThrownBy(() -> queryBuilder.execute(NoIdClass.class, QueryFactory.CREATE.type()))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("Id 어노테이션이 선언되지 않은 필드가 존재합니다.");
        }
    }
}
