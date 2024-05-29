package org.woozi.pratice.entity;

import org.junit.jupiter.api.Test;
import org.woozi.pratice.jakarta.persistence.query.QueryBuilder;
import org.woozi.pratice.jakarta.persistence.query.QueryFactory;

import static org.assertj.core.api.Assertions.assertThat;


class EntityTest {

    @Test
    void Entity_어노테이션_선언_클래스_create_쿼리를_생성한다() {
        // when
        final String actual = QueryBuilder.execute(Person.class, QueryFactory.CREATE.type());

        // then
        final String expected = "CREATE TABLE `persons` (`id` BIGINT NOT NULL AUTO_INCREMENT, `nick_name` VARCHAR(255) NULL, `old` INT NULL, `email` VARCHAR(255) NOT NULL, PRIMARY KEY(`id`));";

        assertThat(actual).isEqualTo(expected);
    }
}
// 컬럼 이름
// 컬럼 타입
// 컬럼 속성
// 컬럼 1 ==== 1 이름
// 컬럼 1 ==== 1 타입
// 컬럼 1 ==== 속성들 -> 속성값들을 반환해줘
// 속성을 반환해서 ->
// 속성이 있을 수도 있고 없을 수도 있음
//
