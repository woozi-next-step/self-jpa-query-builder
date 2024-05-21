package org.woozi.pratice.jakarta.persistence;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QueryBuilder {

    public static final String CREATE_TABLE_QUERY = "CREATE TABLE `%s` (%s);";

    public static String create(final Class<?> clazz) {
        if(!clazz.isAnnotationPresent(Entity.class)) {
            throw new RuntimeException("Entity 어노테이션이 선언되지 않은 클래스입니다.");
        }
        if(Arrays.stream(clazz.getDeclaredFields()).noneMatch(it -> it.isAnnotationPresent(Id.class))) {
            throw new RuntimeException("Id 어노테이션이 선언되지 않은 필드가 존재합니다.");
        }
        final String collect = Arrays.stream(clazz.getDeclaredFields()).sequential()
                .map(it -> switch (it.getType().getTypeName()) {
                    case "java.lang.Long" -> "'%s' bigint".formatted(it.getName());
                    case "java.lang.Integer" -> "'%s' int".formatted(it.getName());
                    case "java.lang.String" -> "'%s' varchar(255)".formatted(it.getName());
                    default -> throw new RuntimeException("지원하지 않는 타입입니다.");
                }).collect(Collectors.joining(", "));

        final String concat = Arrays.stream(clazz.getDeclaredFields())
                .filter(it -> it.isAnnotationPresent(Id.class))
                .findFirst()
                .map(it -> ", PRIMARY KEY (`%s`)".formatted(it.getName()))
                .orElse("");

        return CREATE_TABLE_QUERY.formatted(clazz.getSimpleName().toLowerCase(), collect.concat(concat));
    }
}



